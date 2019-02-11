package org.kamil.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Witaj w programie do fakturowania!");
		model.addAttribute("tagline", "Przejd dalej za pomoc¹ poni¿szych przycisków");
		
		return "welcome";
	}
}