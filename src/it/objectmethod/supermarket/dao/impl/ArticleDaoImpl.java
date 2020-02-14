package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.mapper.ArticleMapper;

public class ArticleDaoImpl implements ArticleDao {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Article> getArticles() {

		String sql = "select a.CODART,a.DESCRIZIONE,\r\n"
				+ " a.PZCART, i.DESCRIZIONE as DESCIVA, f.DESCRIZIONE as DESCFAMASSORT, a.IDIVA, a.IDFAMASS\r\n"
				+ "from articoli a join famassort f on a.IDFAMASS = f.ID \r\n"
				+ "join iva i on a.IDIVA = i.IDIVA limit 200;";

		List<Article> listArticle = jdbcTemplate.query(sql, new ArticleMapper());
		return listArticle;
	}

	@Override
	public int insert(Article article) {
		int resultInsert = 0;

		String codArt = article.getCodArt();
		String descr = article.getDescrizione();
		int pzCart = article.getPzCart();
		int idIva = article.getIdIva();
		int idFamAss = article.getIdFamAss();

		String sql = "INSERT INTO `alphashop`.`articoli` (`CODART`, `DESCRIZIONE`, `PZCART`, `IDIVA`, `IDFAMASS`) VALUES (?, ?, ?, ?, ?);";
		resultInsert = this.jdbcTemplate.update(sql, new Object[] { codArt, descr, pzCart, idIva, idFamAss });

		return resultInsert;

	}

	@Override
	public int update(Article article) {
		int resultUpdate = 0;

		String codArt = article.getCodArt();
		String descr = article.getDescrizione();
		int pzCart = article.getPzCart();
		int idIva = article.getIdIva();
		int idFamAss = article.getIdFamAss();

		String sql = "UPDATE articoli SET DESCRIZIONE= ?, PZCART= ?, IDIVA= ?, IDFAMASS= ? WHERE CODART= ?;";
		resultUpdate = this.jdbcTemplate.update(sql, new Object[] { descr, pzCart, idIva, idFamAss, codArt });

		return resultUpdate;
	}

	@Override
	public Article getArticleByCode(String codArt) {

		Article article = null;

		String sql = "select a.CODART,a.DESCRIZIONE,\r\n"
				+ " a.PZCART, i.DESCRIZIONE as DESCIVA, f.DESCRIZIONE as DESCFAMASSORT, a.IDIVA, a.IDFAMASS\r\n"
				+ "from articoli a join famassort f on a.IDFAMASS = f.ID \r\n"
				+ "join iva i on a.IDIVA = i.IDIVA WHERE CODART = ?";

		try {
			article = this.jdbcTemplate.queryForObject(sql, new Object[] { codArt }, new ArticleMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return article;
	}

}
