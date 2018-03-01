package com.picc.bean.sys;

/**
 * 账号和角色关系
 * @author zhengyi
 * @date 2018年1月9日 下午2:59:22
 */
public class RacAcntRoleRel {

	private String racAcntRoleRelId;	//登录账号角色关联标识符
	private String userAcntId;		//登录账号ID
	private String racRoleId;			//角色ID
	public String getRacAcntRoleRelId() {
		return racAcntRoleRelId;
	}
	public void setRacAcntRoleRelId(String racAcntRoleRelId) {
		this.racAcntRoleRelId = racAcntRoleRelId;
	}
	public String getUserAcntId() {
		return userAcntId;
	}
	public void setUserAcntId(String userAcntId) {
		this.userAcntId = userAcntId;
	}
	public String getRacRoleId() {
		return racRoleId;
	}
	public void setRacRoleId(String racRoleId) {
		this.racRoleId = racRoleId;
	}
	
}
