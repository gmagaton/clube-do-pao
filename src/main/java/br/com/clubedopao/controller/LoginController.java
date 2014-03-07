package br.com.clubedopao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicial(final ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/loginerro", method = RequestMethod.GET)
	public String loginerro(final ModelMap model) {
		model.addAttribute("erro", "true");
		return "login";
	}

}
