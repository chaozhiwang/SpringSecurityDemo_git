package com.picc.bean.sys;

/**
 * 页面权限
 * @author zhengyi
 * @date 2018年1月9日 下午2:59:45
 */
public class RacPrivilege {

	private String racPrivilegeId;		//功能操作权限ID
	private String abbrName;			//昵称简单名
	private String parentId;			//父节点标志符
	private String treePackId;			//树形节点包标识符
	private String name;				//名称
	private String description;			//描述
	private String rpType;				//功能操作类型，比如菜单(SFAMENU)，页面权限(SFAPAGE)
	private String rpTypeCode;			//功能操作类型代码
	private String rpSysRemark;			//功能操作权限系统备注
	private String rpState;				//功能操作权限状态，Y:正常
	
	public String getRacPrivilegeId() {
		return racPrivilegeId;
	}
	public void setRacPrivilegeId(String racPrivilegeId) {
		this.racPrivilegeId = racPrivilegeId;
	}
	public String getAbbrName() {
		return abbrName;
	}
	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getTreePackId() {
		return treePackId;
	}
	public void setTreePackId(String treePackId) {
		this.treePackId = treePackId;
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
	public String getRpType() {
		return rpType;
	}
	public void setRpType(String rpType) {
		this.rpType = rpType;
	}
	public String getRpTypeCode() {
		return rpTypeCode;
	}
	public void setRpTypeCode(String rpTypeCode) {
		this.rpTypeCode = rpTypeCode;
	}
	public String getRpSysRemark() {
		return rpSysRemark;
	}
	public void setRpSysRemark(String rpSysRemark) {
		this.rpSysRemark = rpSysRemark;
	}
	public String getRpState() {
		return rpState;
	}
	public void setRpState(String rpState) {
		this.rpState = rpState;
	}
}
