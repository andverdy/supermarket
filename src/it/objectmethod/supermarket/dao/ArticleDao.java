package it.objectmethod.supermarket.dao;

import java.util.List;

import it.objectmethod.supermarket.model.Article;

public interface ArticleDao {

	public List<Article> getArticles();

	public int insArticle(Article article);

	public void delArticle();

	public int editArticle(Article article);
	
	public Article getArticleByCode(String codArt);
}
