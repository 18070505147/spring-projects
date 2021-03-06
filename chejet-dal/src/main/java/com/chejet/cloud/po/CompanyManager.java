package com.chejet.cloud.po;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import com.chejet.cloud.vo.AppModule;
import com.chejet.cloud.vo.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author ansen.zhu@carlt.com.cn
 * @date 2018/12/14
 */
@Table(name="sys_company_manager")
public class CompanyManager extends Page{
	/**
	 * 编号
	 */
	@AssignID
	@JSONField(serializeUsing = ToStringSerializer.class)
	private Long id;

	private String name;


	private Long userId;
	/**
	 * 关联编号
	 */
	private Long employeeId;

	private Long companyId;
	/**
	 * 名称
	 */
	private Long tenantId;
	
	List<AppModule> appModuleList;

	/**
	 * 创建时间
	 */
	@JsonIgnore
	private Date ctime;

	/**
	 * 更新时间
	 */
	@JsonIgnore
	private Date mtime;

	private static final long serialVersionUID = 1L;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		CompanyManager other = (CompanyManager) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getTenantId() == null ? other.getTenantId() == null
						: this.getTenantId().equals(other.getTenantId()))
				&& (this.getCompanyId() == null ? other.getCompanyId() == null
						: this.getCompanyId().equals(other.getCompanyId()))
				&& (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
				&& (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
		result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
		result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", companyId=").append(companyId);
		sb.append(",tenantId=").append(tenantId);
		sb.append(", ctime=").append(ctime);
		sb.append(", mtime=").append(mtime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	public List<AppModule> getAppModuleList() {
		return appModuleList;
	}

	public void setAppModuleList(List<AppModule> appModuleList) {
		this.appModuleList = appModuleList;
	}
}
