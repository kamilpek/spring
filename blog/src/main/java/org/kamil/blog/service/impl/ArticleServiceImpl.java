package org.kamil.blog.service.impl;

import java.util.List;

import org.kamil.blog.models.Article;
import org.kamil.blog.repository.ArticleRepository;
import org.kamil.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Article addArticle(Article article) {
		return articleRepository.addArticle(article);		
	}

	@Override
	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.getAllArticles();
	}

}
