package com.picc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.picc.bean.User;

@Controller  
@RequestMapping(value = "/main")  
public class MyController {  
    @Autowired  
    @Qualifier("sessionRegistry")  
    private SessionRegistry sessionRegistry;      
      
    @RequestMapping(value = "/admin.do")  
    public ModelAndView adminPage() {  
        ModelAndView model = new ModelAndView();  
        model.addObject("title", "Spring Security Hello World");  
        model.addObject("message", "这是一个安全被保护的页面!");  
        //在MyInvocationSecurityMetadataSource类中指定了保护。  
        model.setViewName("admin");  
  
        return model;  
    }  
      
    @RequestMapping(value = "/welcome.do")  
    public ModelAndView WelcomeAction() {  
        this.PrintAllOnlineUser();  
        ModelAndView model = new ModelAndView();  
        model.addObject("title", "Spring Security Hello World");  
        model.addObject("message", "这是一个欢迎页面!");  
        model.setViewName("welcome");  
        return model;  
    }  
      
    //打印在线用户  
    void PrintAllOnlineUser()  
    {  
        List<Object> principals = sessionRegistry.getAllPrincipals();  
  
        List<String> usersNamesList = new ArrayList<String>();  
  
        for (Object principal: principals) {  
            if (principal instanceof User) {  
                usersNamesList.add(((User) principal).getUsername());  
            }  
        }  
          
        System.out.println("count:"+usersNamesList.size()+"=>"+usersNamesList.toString());  
    }  
      
    @RequestMapping(value="/customLogin.do")    
    public String customLoginAction(HttpServletRequest request){    
        return "customLogin";  
    }  
}