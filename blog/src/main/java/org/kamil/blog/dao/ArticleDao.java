package org.kamil.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.kamil.blog.models.Article;

public class ArticleDao {
	
	@PersistenceContext
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("blog");

	public ArticleDao() {		
		
	}
	
	@Transactional
	public Article addArticle(Article article) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Article insertedArticle = null;
		
		try {
			et = entityManager.getTransaction();
			et.begin();
			entityManager.persist(article);
			et.commit();
		} catch (Exception ex) {

            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {            
    		entityManager.close();
        }
		
		return insertedArticle;
	}
	
	@Transactional
	public Article getArticle(int id) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT a FROM Article a WHERE a.articleID = :articleID";		
		TypedQuery<Article> tq = entityManager.createQuery(query, Article.class);
		tq.setParameter("articleID", id);
		
		Article article = null;	
		try {			
			article = tq.getSingleResult();			
		} catch(NoResultException ex) {
    		ex.printStackTrace();
    	} finally {            
    		entityManager.close();
        }
		
		return article;		
	}
	
	@Transactional
	public List<Article> getAllArticles(){
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT a FROM Article a WHERE a.articleID IS NOT NULL ORDER BY a.articleID DESC";		
		TypedQuery<Article> tq = entityManager.createQuery(strQuery, Article.class);
		
		List<Article> articles = null;
		try {
			articles = tq.getResultList();
		} catch(NoResultException ex) {
    		ex.printStackTrace();
    	} finally {            
    		entityManager.close();
        }
		
		return articles;
	}	

}
