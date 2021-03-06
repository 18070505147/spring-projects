package com.chejet.cloud.vo;

import com.chejet.cloud.common.AppStatusEnum;

import java.util.List;

/**
 * @Description
 * @Date 2018/12/20 13:48
 * @Version 1.0
 */
public class AppDeployModuleVO {
    private Long id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 应用描述
     */
    private String description;

    /**
     * 首页地址
     */
    private String homeUrl;

    /**
     * app版本
     */
    private String appVersion;

    /**
     * 销售版本Id
     */
    private Long marketVersionId;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 应用图标url 应用图标(logo)
     */
    private String iconUrl;

    /**
     * 应用的配置包
     */
    private List<DeployModuleVO> deployModules;

    private Integer appStatus;

    private String appStatusName;

    private String expireTime;

    public Integer getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public String getAppStatusName() {
        if (appStatus != null) {
            switch (appStatus) {
                case 0:
                    appStatusName = AppStatusEnum.TRIAL.getName();
                    break;
                case 1:
                    appStatusName = AppStatusEnum.UNACTIVATED.getName();
                    break;
                case 2:
                    appStatusName = AppStatusEnum.ACTIVATED.getName();
                    break;
                case 3:
                    appStatusName = AppStatusEnum.UNCHECKED.getName();
                    break;
                default:
                    break;
            }
        }
        return appStatusName;
    }

    public void setAppStatusName(String appStatusName) {
        this.appStatusName = appStatusName;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<DeployModuleVO> getDeployModules() {
        return deployModules;
    }

    public void setDeployModules(List<DeployModuleVO> deployModules) {
        this.deployModules = deployModules;
    }

    public Long getMarketVersionId() {
        return marketVersionId;
    }

    public void setMarketVersionId(Long marketVersionId) {
        this.marketVersionId = marketVersionId;
    }
}
