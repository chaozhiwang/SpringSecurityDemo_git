package com.picc.security;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.security.core.Authentication;  
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;  
  
  
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{    
       @Override    
       public void onAuthenticationSuccess(HttpServletRequest request,   
               HttpServletResponse response,    
               Authentication authentication) throws ServletException, IOException   
       {  
           //例1：不跳到XML设定的页面，而是直接返回json字符串  
           response.setCharacterEncoding("UTF-8");  
           response.setContentType("application/json");  
                   
           response.getWriter().println("{\"ok\":\"1\",\"msg\":\"登录成功\"}");  
                  
           //例2：跳转到XML中设定的URL。其实已经没有定义这个class的意义             
           //super.onAuthenticationSuccess(request, response, authentication);  
             
           //例3：自定义跳转到哪个URL  
           //http://cl315917525.iteye.com/blog/1768396  
       }    
} 