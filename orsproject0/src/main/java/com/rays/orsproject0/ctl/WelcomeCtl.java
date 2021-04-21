package com.rays.orsproject0.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contains navigation logics for Welcome.
 * 
 * @author Neeraj
 */
@Controller
@RequestMapping("/Welcome")
public class WelcomeCtl {
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String display(Model model) {
		System.out.println("welcome page starts");
		return "Welcome";
	}

}
