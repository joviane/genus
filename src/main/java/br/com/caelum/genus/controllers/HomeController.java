package br.com.caelum.genus.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
	return "index";
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
	return principal;
    }
}
