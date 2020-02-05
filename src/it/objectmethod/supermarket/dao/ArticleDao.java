package it.objectmethod.supermarket.dao;

import java.util.List;
import java.util.Map;

import it.objectmethod.supermarket.model.Article;

public interface ArticleDao {

	public Map<Article,String> getArticles();

	public int saveOrUpdate(Article article);
	
	public void delArticle();

	public Article getArticleByCode(String codArt);
}
