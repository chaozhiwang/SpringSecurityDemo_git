package com.picc.bean.sys;

/**
 * 角色表
 * @author zhengyi
 * @date 2018年1月9日 下午2:58:35
 */
public class RacRole {
	
	private String racRoleId;			//角色ID
	private String name;				//名称
	private String code;				//代码
	private String description;			//描述
	public String getRacRoleId() {
		return racRoleId;
	}
	public void setRacRoleId(String racRoleId) {
		this.racRoleId = racRoleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
