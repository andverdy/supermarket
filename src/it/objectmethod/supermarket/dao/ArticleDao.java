package it.objectmethod.supermarket.dao;

import java.util.List;

import it.objectmethod.supermarket.model.Article;

public interface ArticleDao {

	public List<Article> getArticles();

	public void insArticle(Article article);

	public void delArticle();

	public List<Article> updArticle();
}
