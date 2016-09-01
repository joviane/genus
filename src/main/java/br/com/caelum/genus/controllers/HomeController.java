package br.com.caelum.genus.controllers;

import javax.persistence.Convert;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index() {
		
		String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ModelAndView("/index").addObject("user", user);
	}
}
