package com.picc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationException extends AuthenticationException {  
  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
    private static final Logger log = LoggerFactory.getLogger(MyAuthenticationException.class);
    
    public MyAuthenticationException(String msg) {  
        super(msg);  
    }  
  
}  
