package it.objectmethod.supermarket.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.supermarket.model.Article;

public class ArticleMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

		Article article = new Article();
		article.setCodArt(rs.getString("CODART"));
		article.setDescrizione(rs.getString("DESCRIZIONE"));
		article.setPzCart(rs.getInt("PZCART"));
		article.setIvaDesc(rs.getString("DESCIVA"));
		article.setFamAssDesc(rs.getString("DESCFAMASSORT"));
		article.setIdIva(rs.getInt("IDIVA"));
		article.setIdFamAss(rs.getInt("IDFAMASS"));

		return article;
	}

}
