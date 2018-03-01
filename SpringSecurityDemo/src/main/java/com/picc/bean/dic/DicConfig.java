package com.picc.bean.dic;
/**
 * 字典配置表
 * @author zhengyi
 * @date 2018年1月9日 下午2:15:35
 */
public class DicConfig {
	private String dicConfigId;		//字典配置id
	private String abbrName;		//昵称简单名
	private String name;			//名称
	private String code;			//代码
	private String dcState;			//状态,Y:正常,N:不正常
	
	public String getDicConfigId() {
		return dicConfigId;
	}
	public void setDicConfigId(String dicConfigId) {
		this.dicConfigId = dicConfigId;
	}
	public String getAbbrName() {
		return abbrName;
	}
	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
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
	public String getDcState() {
		return dcState;
	}
	public void setDcState(String dcState) {
		this.dcState = dcState;
	}
	
}
