package com.chejet.cloud.vo;

import org.beetl.sql.core.annotatoin.AssignID;
import com.chejet.cloud.po.CompanyManager;
import org.beetl.sql.core.annotatoin.Table;

@Table(name="sys_company_manager")
public class CompanyManagerVO extends CompanyManager {
	Integer appId;
	String appName;
	String functionId;
	String functionName;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

}
