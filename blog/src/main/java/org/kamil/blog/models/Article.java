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
	
	@Column(name = "uploadFile", nullable = false)
	private String uploadFile;
	
	public Article() {
		super();
	}	

	public Article(int articleID, String title, String intro, String content, String author, Timestamp created,
			String uploadFile) {
		super();
		this.articleID = articleID;
		this.title = title;
		this.intro = intro;
		this.content = content;
		this.author = author;
		this.created = created;
		this.uploadFile = uploadFile;
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
		if(title != null && title.length() > 0) {
			this.title = title;
		} else {
			throw new IllegalArgumentException("Pusty tytuł");
		}		
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		if(intro != null && intro.length() > 0) {
			this.intro= intro;
		} else {
			throw new IllegalArgumentException("Pusty tytuł");
		}		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		if(content != null && content.length() > 0) {
			this.content = content;
		} else {
			throw new IllegalArgumentException("Pusty tytuł");
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author != null && author.length() > 0) {
			this.author = author;
		} else {
			throw new IllegalArgumentException("Pusty tytuł");
		}
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

}
