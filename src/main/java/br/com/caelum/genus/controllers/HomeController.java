package br.com.caelum.genus.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index() {
	return new ModelAndView("index");
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
	return principal;
    }
}
