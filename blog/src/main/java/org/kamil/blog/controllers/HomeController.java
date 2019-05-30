package org.kamil.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    String getView(Model model) {
		model.addAttribute("greeting", "Blog");		
		model.addAttribute("tagline", "Witamy na blogu");
        return "home";
    }

}
