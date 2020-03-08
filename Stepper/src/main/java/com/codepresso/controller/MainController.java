package com.codepresso.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@RequestMapping("/")
	public ModelAndView index(@CookieValue(value = "accesstoken", required = false) String accesstoken) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("user", accesstoken);
		return mav;
	}

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("/post/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		return mav;
	}

}
