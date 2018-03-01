package com.picc.bean.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/***
 * 用户实体类扩展
 * @author zhengyi
 * @date 2018年1月9日 下午2:14:34
 */
public class UserAccount extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAccount(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	private String userAcntId;		//登录用户id
	private String name; 			//登录用户账号
	private String password;
	private String standardCode; 	//用户code
	private String description;
	private String uacntState; 		//用户状态
	private String uacntSystemCode;	
	
	public String getUserAcntId() {
		return userAcntId;
	}

	public void setUserAcntId(String userAcntId) {
		this.userAcntId = userAcntId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStandardCode() {
		return standardCode;
	}

	public void setStandardCode(String standardCode) {
		this.standardCode = standardCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUacntState() {
		return uacntState;
	}

	public void setUacntState(String uacntState) {
		this.uacntState = uacntState;
	}

	public String getUacntSystemCode() {
		return uacntSystemCode;
	}

	public void setUacntSystemCode(String uacntSystemCode) {
		this.uacntSystemCode = uacntSystemCode;
	}

	
	
}
