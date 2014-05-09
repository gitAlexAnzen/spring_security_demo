/*
 * Copyright (c) 2014 Anzen Soluciones S.A. de C.V. Mexico D.F. All rights reserved. THIS
 * SOFTWARE IS CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES. THIS INFORMATION SHOULD
 * NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY
 * ITSELF.
 */
package mx.com.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * TODO [Add comments of the class]
 * @author Javier Alexander Bravo Rosales(jbravor@anzen.com.mx)
 * @version 1.0
 * @since MFM 1.0
 */

@Controller
public class SecurityController extends WebMvcConfigurerAdapter {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login_page";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {

		String name = principal.getName();
		model.addAttribute("username", name);
		return "main_page";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "hello";

	}

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("mensaje", "Tpagiged ptegidapage!");
		model.setViewName("admin");
		System.out.println("datos fake");
		return model;

	}

}
