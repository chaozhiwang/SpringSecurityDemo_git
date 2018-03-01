package com.picc.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationFailureHandlerImpl.class);


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		log.info("失败跳转页面contextPath:{}", request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/fail.jsp");
	}
	
	

}
