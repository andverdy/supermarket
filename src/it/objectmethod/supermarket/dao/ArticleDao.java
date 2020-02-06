package it.objectmethod.supermarket.dao;

import java.util.List;

import it.objectmethod.supermarket.model.Article;

public interface ArticleDao {

	public List<Article> getArticles();

	public int saveOrUpdate(Article article);
	
	public void delArticle();

	public Article getArticleByCode(String codArt);
}
