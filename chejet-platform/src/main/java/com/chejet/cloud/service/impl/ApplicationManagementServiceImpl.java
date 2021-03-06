package com.chejet.cloud.service.impl;


import com.chejet.cloud.common.ErrorCodeEnum;
import com.chejet.cloud.constant.Constants;
import com.chejet.cloud.dao.ApplicationManagementMapper;
import com.chejet.cloud.exception.BaseException;
import com.chejet.cloud.po.App;
import com.chejet.cloud.po.RelTenantApp;
import com.chejet.cloud.po.SysAppVersion;
import com.chejet.cloud.po.TenantOrder;
import com.chejet.cloud.service.ApplicationManagementService;
import com.chejet.cloud.util.DateUtils;
import com.chejet.cloud.util.LongIdGen;
import com.chejet.cloud.util.StringUtils;
import com.chejet.cloud.vo.AppVO;
import com.chejet.cloud.vo.IdVO;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Bean.Wang
 * @Date: 2018/12/11 14:18
 */
@Service
public class ApplicationManagementServiceImpl implements ApplicationManagementService {
    @Autowired
    private SQLManager sqlManager;

    @Autowired
    private ApplicationManagementMapper managementMapper;

    @Override
    public PageQuery<AppVO> appFoPage(Long tenantId, String nameCondition, Integer pageNo, Integer pageSize) {
        if (pageSize == null) {
            pageSize = 20;
        }
        if (nameCondition != null && !nameCondition.contains("%")) {
            nameCondition = "%" + nameCondition + "%";
        } else if(nameCondition != null &&nameCondition.contains("%")) {
            return null;
        }
        PageQuery<AppVO> pageQuery = new PageQuery<>();
        pageQuery.setPageNumber(pageNo);
        pageQuery.setPageSize(pageSize);
        Integer count = managementMapper.findAppCountFoTenant(tenantId, nameCondition);
        List<AppVO> appList = managementMapper.findAppFoTenant(tenantId, nameCondition, ((pageNo - 1) * pageSize), pageSize);
        appList.forEach(appVO -> {
            if (StringUtils.isEmpty(appVO.getIconUrl())){
                appVO.setIconUrl(Constants.DEFAULT_ICON);
            }
        });
        pageQuery.setTotalRow(count);
        pageQuery.setList(appList);
        return pageQuery;
    }

    @Override
    public List<AppVO> findNotAddedApp(Long tenantId) {
        List<App> notAddedApp = managementMapper.findNotAddedApp(tenantId);
        List<AppVO> appVOList = new ArrayList<>();
        notAddedApp.forEach(m -> {
            AppVO appVO = new AppVO();
            List<SysAppVersion> versionList = sqlManager.lambdaQuery(SysAppVersion.class)
                    .andEq(SysAppVersion::getAppId, m.getId()).select();

            appVO.setVersionList(versionList);
            BeanUtils.copyProperties(m, appVO);
            if (StringUtils.isEmpty(appVO.getIconUrl())){
                appVO.setIconUrl(Constants.DEFAULT_ICON);
            }
            appVOList.add(appVO);
        });
        return appVOList;
    }

    @Override
    @Transactional
    public Boolean saveApp(List<IdVO> idVOList) {
        if (idVOList == null) {
            throw new BaseException(ErrorCodeEnum.PARAM_ERROR);
        }
        idVOList.forEach(idVO -> {
            if (idVO.getTenantId() == null
                    || idVO.getAppId() == null
                    || idVO.getVersionId() == null) {

            }
            Long tenantId = idVO.getTenantId();
            Long appId = idVO.getAppId();
            Long versionId = idVO.getVersionId();
            RelTenantApp relTenantApp = new RelTenantApp();
            relTenantApp.setId(LongIdGen.get().nextId());
            relTenantApp.setAppId(appId);
            relTenantApp.setTenantId(tenantId);
            relTenantApp.setVersionId(versionId);
            relTenantApp.setAppStatus(0);
            Date date = DateUtils.parseDate(DateUtils.dateAdd(DateUtils.getDate(), 30));
            if (date == null) {
                throw new BaseException(ErrorCodeEnum.DB_INSERT_FAIL);
            }
            relTenantApp.setExpireTime(date);
            sqlManager.insertTemplate(relTenantApp);
//TODO 订单逻辑，待后续确认
            TenantOrder tenantOrder = new TenantOrder();
            tenantOrder.setId(LongIdGen.get().nextId());
            tenantOrder.setTenantId(tenantId);
            tenantOrder.setAppId(appId);
            tenantOrder.setOrderNo(LongIdGen.get().nextId()+"");
            tenantOrder.setUserId(idVO.getUserId());
            sqlManager.insertTemplate(tenantOrder);
        });
        return true;
    }


    @Override
    public List<App> getAppByCompanyId(Long tenantId, Long companyId) {
        List<App> appList = managementMapper.findAppByCompany(tenantId, companyId);
        return appList;
    }
}
