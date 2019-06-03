package org.kamil.blog.controllers;

import java.util.Collection;

import org.kamil.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		boolean permission = authorities.contains(authority);
		modelAndView.addObject("permission", permission);
		
		return modelAndView;
    }

}
