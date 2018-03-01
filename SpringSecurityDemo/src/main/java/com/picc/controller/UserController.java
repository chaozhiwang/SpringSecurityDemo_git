package com.picc.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {
	
	@RequestMapping(value = "/index")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/index.html");
		return view;
	}
}
