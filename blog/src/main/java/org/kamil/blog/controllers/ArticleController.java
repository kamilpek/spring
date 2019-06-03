package org.kamil.blog.controllers;

import java.sql.Timestamp;
import java.util.Date;

import org.kamil.blog.models.Article;
import org.kamil.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping({"/all", "/"})
	public ModelAndView allArticles() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("articles", articleService.getAllArticles());
		modelAndView.setViewName("articles");
		return modelAndView;
	}
	
	@RequestMapping("/article")
	public String getProductById(@RequestParam("id") String articleID, Model model) {
		Article article = articleService.getArticle(Integer.parseInt(articleID));				
		model.addAttribute("article", article);
		return "article";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewArticleForm(@ModelAttribute("newArticle") Article newArticle) {
	   return "addArticle";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewClientForm(@ModelAttribute("newArticle") Article articleToBeAdded, ModelMap map, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		Date date = new java.util.Date();
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		articleToBeAdded.setCreated(timestamp);
		articleService.addArticle(articleToBeAdded);
		return "redirect:/articles/all";
	}

}
