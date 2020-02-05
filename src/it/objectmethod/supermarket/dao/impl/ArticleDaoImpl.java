package it.objectmethod.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import it.objectmethod.supermarket.config.ConnectionConfig;
import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.model.Article;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public Map<Article,String> getArticles() {

		Article article = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Map<Article,String> mapArticles = new TreeMap<>();

		try {
			conn = ConnectionConfig.getConnection();
			String sql = "select a.CODART,a.DESCRIZIONE, a.PZCART, a.IDIVA, f.DESCRIZIONE as DESCFAMASSORT\r\n" + 
					"from articoli a, famassort f\r\n" + 
					"where a.IDFAMASS = f.ID";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				article = new Article();
				article.setCodArt(rs.getString("CODART"));
				article.setDescrizione(rs.getString("DESCRIZIONE"));
				article.setPzCart(rs.getInt("PZCART"));
				article.setIdIva(rs.getInt("IDIVA"));
				
				mapArticles.put(article, rs.getString("DESCFAMASSORT"));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return mapArticles;
	}

	@Override
	public int saveOrUpdate(Article article) {
		Connection conn = null;
		PreparedStatement stm = null;
		int result = 0;
		String sql = null;

		
		conn = ConnectionConfig.getConnection();
		try {

			if(getArticleByCode(article.getCodArt()) != null) {
				sql = "UPDATE articoli SET DESCRIZIONE= ?, PZCART= ?, IDIVA= ?, IDFAMASS= ? WHERE CODART= ?;";
				stm = conn.prepareStatement(sql);
				stm.setString(1, article.getDescrizione());
				stm.setInt(2, article.getPzCart());
				stm.setInt(3, article.getIdIva());
				stm.setInt(4, article.getIdFamAss());
				stm.setString(5, article.getCodArt());
				
			}
			else {
				sql = "INSERT INTO `alphashop`.`articoli` (`CODART`, `DESCRIZIONE`, `PZCART`, `IDIVA`, `IDFAMASS`) VALUES (?, ?, ?, ?, ?);";
				stm = conn.prepareStatement(sql);
				stm.setString(1, article.getCodArt());
				stm.setString(2, article.getDescrizione());
				stm.setInt(3, article.getPzCart());
				stm.setInt(4, article.getIdIva());
				stm.setInt(5, article.getIdFamAss());
			}

			
			result = stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
		
	}

	@Override
	public void delArticle() {

	}

	@Override
	public Article getArticleByCode(String codArt) {

		Connection conn = null;
		PreparedStatement stm = null;
		Article article = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT CODART, DESCRIZIONE, PZCART, IDIVA, IDFAMASS FROM articoli WHERE CODART = ?;";
			conn = ConnectionConfig.getConnection();
			stm = conn.prepareStatement(sql);

			stm.setString(1, codArt);
			rs = stm.executeQuery();

			while (rs.next()) {
				article = new Article();
				
				article.setCodArt(rs.getString("CODART"));
				article.setDescrizione(rs.getString("DESCRIZIONE"));
				article.setPzCart(rs.getInt("PZCART"));
				article.setIdIva(rs.getInt("IDIVA"));
				article.setIdFamAss(rs.getInt("IDFAMASS"));
			}

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return article;
	}

}
