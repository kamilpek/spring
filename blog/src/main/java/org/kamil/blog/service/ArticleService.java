package org.kamil.blog.service;

import java.util.List;

import org.kamil.blog.models.Article;

public interface ArticleService {
	
	Article addArticle(Article article);
	
	Article getArticle(int id);
	
	List<Article> getAllArticles();

}
