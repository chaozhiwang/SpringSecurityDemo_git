package com.picc.bean.sys;

/**
 * 角色和页面权限关系
 * @author zhengyi
 * @date 2018年1月9日 下午2:58:55
 */
public class RacRlPaRel {

	private String racRlPaRelId;	//角色功能关联ID
	private String racRoleId;		//角色ID
	private String racPrivilegeId;	//功能操作权限ID
	
	public String getRacRlPaRelId() {
		return racRlPaRelId;
	}
	public void setRacRlPaRelId(String racRlPaRelId) {
		this.racRlPaRelId = racRlPaRelId;
	}
	public String getRacRoleId() {
		return racRoleId;
	}
	public void setRacRoleId(String racRoleId) {
		this.racRoleId = racRoleId;
	}
	public String getRacPrivilegeId() {
		return racPrivilegeId;
	}
	public void setRacPrivilegeId(String racPrivilegeId) {
		this.racPrivilegeId = racPrivilegeId;
	}
	
	
}
