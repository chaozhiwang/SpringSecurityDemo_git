package com.picc.security;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.picc.bean.sys.RacRole;
import com.picc.bean.user.UserAccount;
import com.picc.dao.RacAcntRoleRelMapper;
import com.picc.dao.UserAccountMapper;


/**
 *通过MyUserDetailServiceImpl拿到用户信息后，authenticationManager对比用户的密码（即验证用户）
 * User userdetail该类实现 UserDetails 接口，该类在验证成功后会被保存在当前回话的principal对象中
 * 获得对象的方式：
 * WebUserDetails webUserDetails = (WebUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 * 
 * 或在JSP中：
 * <sec:authentication property="principal.username"/>
 * 
 * 如果需要包括用户的其他属性，可以实现 UserDetails 接口中增加相应属性即可
 * 权限验证类
 * @author lanyuan
 * 2013-11-19
 * @author limingxing
 * @2015-12-2
 * version 1.0v
 */
@Service("myUserDetailServiceImpl2")
public class MyUserDetailServiceImpl2 implements UserDetailsService{
	private static final Logger log = LoggerFactory.getLogger(MyUserDetailServiceImpl2.class);
	@Autowired
	private UserAccountMapper userMapper;
	@Autowired
	private RacAcntRoleRelMapper roleMapper;
	
	private Map<String, UserAccount> userMap = null;  
	
	/**
	 *  登陆验证时，通过username获取用户的所有权限信息，
	 *  并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	 */
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		log.info("----2.MyUserDetailServiceImpl2.loadUserByUsername");
		log.info("验证用户权限就,loginName:{}",loginName);
		if(userMap==null) {
			userMap = new HashMap<String, UserAccount>();
		}
		
		UserAccount user = userMapper.getUserAcountByLoginName(loginName);
		
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(), true, true, true, true,grantedAuths);
		return userdetail;
	}
	
	/**
	 * 
	 * 方法描述：   获取用户权限
	 * 创建人：zhengyi   
	 * 创建时间：2018年1月11日 上午9:25:59 
	 * @param user
	 * @return
	 */
	private Set<GrantedAuthority> obtionGrantedAuthorities(UserAccount user) {
		log.info("----3.MyUserDetailServiceImpl2.obtionGrantedAuthorities");
		List<RacRole> roles = roleMapper.listUserAcntRoles(user.getUserAcntId());
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (RacRole res : roles) {
			// 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			authSet.add(new SimpleGrantedAuthority(res.getCode()));
		}
		return authSet;
	}
	
	
	/**
	 *取得用户的权限
	 * @param user
	 * @return
	 */
//	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
//		log.info("----3.MyUserDetailServiceImpl2.obtionGrantedAuthorities");
//		List<Role> roles = roleDAO.findRolesByLoginName(user.getLoginName());
//		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
//		for (Role res : roles) {
//			// 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
//			authSet.add(new SimpleGrantedAuthority(res.getRoleName()));
//		}
//		return authSet;
//	}
	
	
	
}
