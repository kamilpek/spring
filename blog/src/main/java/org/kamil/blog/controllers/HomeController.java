package org.kamil.blog.controllers;

import org.kamil.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/")
	ModelAndView getView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articles", articleService.getAllArticles());
		modelAndView.addObject("greeting", "Blog");
		modelAndView.addObject("tagline", "Witamy na blogu");
		modelAndView.setViewName("home");
		return modelAndView;
    }

}
