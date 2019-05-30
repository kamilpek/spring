package org.kamil.blog.repository;

import java.util.List;

import org.kamil.blog.models.Article;

public interface ArticleRepository {
	
	Article addArticle(Article article);
	
	Article getArticle(int id);
	
	List<Article> getAllArticles();

}
