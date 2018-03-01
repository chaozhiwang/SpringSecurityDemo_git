package com.picc.security;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;  
import org.springframework.security.core.AuthenticationException;  
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.picc.bean.user.UserAccount;
import com.picc.dao.UserAccountMapper;  
  
/* 
 * 说明： 
 * UsernamePasswordAuthenticationFilter用于处理来自表单提交的认证。该表单必须提供对应的用户名和密码， 
 * 对应的参数名默认为j_username和j_password。 
 * 如果不想使用默认的参数名，可以通过UsernamePasswordAuthenticationFilter的usernameParameter和passwordParameter进行指定。 
 * 表单的提交路径默认是“j_spring_security_check”，可以通过UsernamePasswordAuthenticationFilter的filterProcessesUrl进行指定。 
 * 通过属性postOnly可以指定只允许登录表单进行post请求，默认是true。 
 */  
  
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private static final Logger log = LoggerFactory.getLogger(MyAuthenticationFilter.class);
	public static final String VALIDATE_CODE = "validateCode";  
    public static final String USERNAME = "username";  
    public static final String PASSWORD = "password"; 
    public static final String USERTYPE = "userType"; 
      
	@Autowired
	private UserAccountMapper userMapper;
	
    public Authentication attemptAuthentication(HttpServletRequest request,    
            HttpServletResponse response) throws AuthenticationException {        
        //这里可以抛出继承自AuthenticationException的exception  
        //然后会转到MyAuthenticationFailureHandler。        
        //比如说验证码什么的可以在这里验证，然后抛出异常。  
        //然后让MyAuthenticationFailureHandler去处理，并输出返回  
          
        //下面的代码段是具体的示例  
        //当用户输入的用户名为“123”抛出自定义的AuthenticationException异常。  
        
        String username = obtainUsername(request);  
        String password = obtainPassword(request);  
        String acntType = obtainAcntType(request);  
        
//        UserAccount userAcnt = new UserAccount();
//        userAcnt.setUacntSystemCode(acntType);
//        userAcnt.setName(username);
        log.info("用户验证username:{},password:{},acntType:{}",username,password,acntType);
        //验证用户账号与密码是否对应
//        username = username.trim();
        
        UserAccount user = this.userMapper.getUserAcountByLoginName(username);
        if(user==null) {
        	throw new AuthenticationServiceException("账号不存在!");  
        }else {
        	if(!acntType.equals(user.getUacntSystemCode())) {
        		 throw new AuthenticationServiceException("请选择正确的账号类型!");
        	}
        	String passwordNew = user.getPassword();
        	if(!password.equals(passwordNew)) {
        		 throw new AuthenticationServiceException("用户名或者密码错误!"); 
        	}
        }
        
        //UsernamePasswordAuthenticationToken实现 Authentication  
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);  
        // Place the last username attempted into HttpSession for views  
          
        // 允许子类设置详细属性  
        setDetails(request, authRequest);  
          
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication  
        return this.getAuthenticationManager().authenticate(authRequest);     
    }  
    
    @Override  
    protected String obtainUsername(HttpServletRequest request) {  
        Object obj = request.getParameter(USERNAME);  
        return null == obj ? "" : obj.toString();  
    }  
  
    @Override  
    protected String obtainPassword(HttpServletRequest request) {  
        Object obj = request.getParameter(PASSWORD);  
        return null == obj ? "" : obj.toString();  
    }  
    
    protected String obtainAcntType(HttpServletRequest request) {  
        Object obj = request.getParameter(USERTYPE);  
        return null == obj ? "" : obj.toString();  
    }  
}  