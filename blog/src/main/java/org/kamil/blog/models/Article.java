package org.kamil.blog.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {	
	
	@Id
	@Column(name = "articleID", unique = true)
	private int articleID;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "intro", nullable = false)
	private String intro;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "created", nullable = false)
	Timestamp created;
	
	public Article() {
		super();
	}	

	public Article(int articleID, String title, String intro, String content, String author, Timestamp created) {
		super();
		this.articleID = articleID;
		this.title = title;
		this.intro = intro;
		this.content = content;
		this.author = author;
		this.created = created;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}	

}
