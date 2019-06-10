package org.kamil.blog;

import org.kamil.blog.models.Article;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.After;

public class ArticleTest {	
	
	private Article article;
	
	@Before
	public void before() {		
		article = new Article();	
	}
	
	@Test
	public void setTitle() {
		article.setTitle("Pan Tadeusz");
		assertEquals("Pan Tadeusz", article.getTitle());
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyTitle() {
		article.setTitle("");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setWrongTitle() {
		article.setTitle(null);
	}
	
	@Test
	public void setAuthor() {
		article.setAuthor("Adam Mickiewicz");
		assertEquals("Adam Mickiewicz", article.getAuthor());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyAuthor() {
		article.setAuthor("");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNullAuthor() {
		article.setAuthor(null);		
	}
	
	@Test
	public void setIntro() {
		article.setIntro("Litwo! Ojczyzno moja! Ty jesteś jak zdrowie.");
		assertEquals("Litwo! Ojczyzno moja! Ty jesteś jak zdrowie.", article.getIntro());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyIntro() {
		article.setIntro("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNullIntro() {
		article.setIntro(null);
	}
	
	@Test
	public void setContent() {
		article.setContent("Nazywał się stało wody pełne naczynie blaszane ale nic nie był portret króla Lecha");
		assertEquals("Nazywał się stało wody pełne naczynie blaszane ale nic nie był portret króla Lecha", article.getContent());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyContent() {
		article.setContent("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNullContent() {
		article.setContent(null);
	}
	
	@After
	public void after() {
		article = null;
	}
}
