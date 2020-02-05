package it.objectmethod.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.supermarket.config.ConnectionConfig;
import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.model.Article;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<Article> getArticles() {

		Article article = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Article> listArticles = new ArrayList<>();

		try {
			conn = ConnectionConfig.getConnection();
			String sql = "SELECT * FROM ARTICOLI";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				article = new Article();
				article.setCodArt(rs.getString("CODART"));
				article.setDescrizione(rs.getString("DESCRIZIONE"));
				article.setPzCart(rs.getInt("PZCART"));
				article.setIdIva(rs.getInt("IDIVA"));
				article.setIdFamAss(rs.getInt("IDFAMASS"));

				listArticles.add(article);
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

		return listArticles;
	}

	@Override
	public int insArticle(Article article) {

		String sql = "INSERT INTO `alphashop`.`articoli` (`CODART`, `DESCRIZIONE`, `PZCART`, `IDIVA`, `IDFAMASS`) VALUES (?, ?, ?, ?, ?);";
		Connection conn = null;
		PreparedStatement stm = null;

		int result = 0;
		try {

			conn = ConnectionConfig.getConnection();

			stm = conn.prepareStatement(sql);

			stm.setString(1, article.getCodArt());
			stm.setString(2, article.getDescrizione());
			stm.setInt(3, article.getPzCart());
			stm.setInt(4, article.getIdIva());
			stm.setInt(5, article.getIdFamAss());

			result = stm.executeUpdate();
			System.out.println("stampa result dentro dao " + result);

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
	public int editArticle(Article articleParam) {

		String sql = "UPDATE articoli SET DESCRIZIONE= ?, PZCART= ?, IDIVA= ?, IDFAMASS= ? WHERE CODART= ?;";
		Connection conn = null;
		PreparedStatement stm = null;
		Article article = new Article();
		int result = 0;

		try {

			conn = ConnectionConfig.getConnection();

			stm = conn.prepareStatement(sql);

			stm.setString(1, articleParam.getDescrizione());
			stm.setInt(2, articleParam.getPzCart());
			stm.setInt(3, articleParam.getIdIva());
			stm.setInt(4, articleParam.getIdFamAss());
			stm.setString(5, articleParam.getCodArt());
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
	public Article getArticleByCode(String codArt) {

		Connection conn = null;
		PreparedStatement stm = null;
		Article article = new Article();
		ResultSet rs = null;

		try {
			String sql = "SELECT CODART, DESCRIZIONE, PZCART, IDIVA, IDSTATOART, IDFAMASS FROM articoli WHERE CODART = ?;";
			conn = ConnectionConfig.getConnection();
			stm = conn.prepareStatement(sql);

			stm.setString(1, codArt);
			rs = stm.executeQuery();

			while (rs.next()) {

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
