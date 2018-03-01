package com.picc.bean.user;

/**
 * 用户关系表
 * @author chaozhiwang
 * @date 2018年1月9日 下午2:42:10
 */
public class UserUserRel {

	private String userUserAcntId;
	private String uurType;					//关系，比如公司与员工
	private String uurTypeCode;
	private String uurAAcntName;
	private String uurAAcntCode;
	private String uurABcntName;
	private String uurABcntCode;
	private String uurState;
	
	
	public String getUserUserAcntId() {
		return userUserAcntId;
	}
	public void setUserUserAcntId(String userUserAcntId) {
		this.userUserAcntId = userUserAcntId;
	}
	public String getUurType() {
		return uurType;
	}
	public void setUurType(String uurType) {
		this.uurType = uurType;
	}
	public String getUurTypeCode() {
		return uurTypeCode;
	}
	public void setUurTypeCode(String uurTypeCode) {
		this.uurTypeCode = uurTypeCode;
	}
	public String getUurAAcntName() {
		return uurAAcntName;
	}
	public void setUurAAcntName(String uurAAcntName) {
		this.uurAAcntName = uurAAcntName;
	}
	public String getUurAAcntCode() {
		return uurAAcntCode;
	}
	public void setUurAAcntCode(String uurAAcntCode) {
		this.uurAAcntCode = uurAAcntCode;
	}
	public String getUurABcntName() {
		return uurABcntName;
	}
	public void setUurABcntName(String uurABcntName) {
		this.uurABcntName = uurABcntName;
	}
	public String getUurABcntCode() {
		return uurABcntCode;
	}
	public void setUurABcntCode(String uurABcntCode) {
		this.uurABcntCode = uurABcntCode;
	}
	public String getUurState() {
		return uurState;
	}
	public void setUurState(String uurState) {
		this.uurState = uurState;
	}
	
}
