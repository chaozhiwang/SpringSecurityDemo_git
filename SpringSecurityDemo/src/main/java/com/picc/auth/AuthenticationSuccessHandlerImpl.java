package com.picc.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
//		response.sendRedirect(request.getContextPath()+"/WEB-INF/views/index.jsp");
		log.info("登录成功");
//		request.getRequestDispatcher("WEB-INF/views/index3.html").forward(request, response);
//		request.getRequestDispatcher("/index.html").forward(request, response);
		response.sendRedirect("/index.html");
		
		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("basic");
//		return new ModelAndView("/WEB-INF/views/index.jsp");
		
	}

}
