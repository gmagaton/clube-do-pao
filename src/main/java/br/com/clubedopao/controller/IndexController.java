package br.com.clubedopao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final Model model){
		return new ModelAndView("index");
	}

}
