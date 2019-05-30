package org.kamil.blog.repository.impl;

import java.util.List;

import org.kamil.blog.dao.ArticleDao;
import org.kamil.blog.models.Article;
import org.kamil.blog.repository.ArticleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
	
	private ArticleDao articleDao;

	public ArticleRepositoryImpl() {	
		articleDao = new ArticleDao();
	}

	@Override
	public Article addArticle(Article article) {
		articleDao.addArticle(article);
		return null;
	}

	@Override
	public Article getArticle(int id) {
		return articleDao.getArticle(id);		
	}

	@Override
	public List<Article> getAllArticles() {
		return articleDao.getAllArticles();
	}

}
