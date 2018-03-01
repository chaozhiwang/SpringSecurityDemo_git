package com.picc.bean.dic;

/**
 * 字典表
 * @author zhengyi
 * @date 2018年1月9日 下午2:15:35
 */
public class DicCode {
	
	private String name;			//名称
	private String code;			//
	private String description;		//描述
	private String dicCodeState;	//状态，Y:正常
	
	
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
	public String getDicCodeState() {
		return dicCodeState;
	}
	public void setDicCodeState(String dicCodeState) {
		this.dicCodeState = dicCodeState;
	}
	
}
