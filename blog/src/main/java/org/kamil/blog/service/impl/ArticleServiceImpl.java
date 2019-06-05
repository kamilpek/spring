package org.kamil.blog.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.kamil.blog.models.Article;
import org.kamil.blog.repository.ArticleRepository;
import org.kamil.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public String saveImage(MultipartFile imageFile) throws Exception {
		String fileName = imageFile.getOriginalFilename().replaceFirst("[.][^.]+$", "");
		String fileExt = imageFile.getOriginalFilename().split("\\.")[1];		
		String file = fileName + (int) (Math.random() * (9999 - 1000)) + "." + fileExt;		
		
		byte[] bytes = imageFile.getBytes();		
		Path path = Paths.get(new File("src\\main\\webapp\\WEB-INF\\images").getAbsolutePath() + "\\articles\\" + file);
		Files.write(path, bytes);
		
		return file;
	}

}
