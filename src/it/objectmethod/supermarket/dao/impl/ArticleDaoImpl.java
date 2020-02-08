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

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Article> listArticle = new ArrayList<Article>();

		try {
			conn = ConnectionConfig.getConnection();
			String sql = "select a.CODART,a.DESCRIZIONE,\r\n"
					+ " a.PZCART, i.DESCRIZIONE as DESCIVA, f.DESCRIZIONE as DESCFAMASSORT, a.IDIVA, a.IDFAMASS\r\n"
					+ "from articoli a join famassort f on a.IDFAMASS = f.ID \r\n"
					+ "join iva i on a.IDIVA = i.IDIVA limit 200;";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {

				Article article = new Article();
				article.setCodArt(rs.getString("CODART"));
				article.setDescrizione(rs.getString("DESCRIZIONE"));
				article.setPzCart(rs.getInt("PZCART"));
				article.setIvaDesc(rs.getString("DESCIVA"));
				article.setFamAssDesc(rs.getString("DESCFAMASSORT"));
				article.setIdIva(rs.getInt("IDIVA"));
				article.setIdFamAss(rs.getInt("IDFAMASS"));

				listArticle.add(article);

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

		return listArticle;
	}

	@Override
	public int insert(Article article) {
		Connection conn = null;
		PreparedStatement stm = null;
		int resultInsert = 0;
		String sql = null;

		conn = ConnectionConfig.getConnection();
		try {

			sql = "INSERT INTO `alphashop`.`articoli` (`CODART`, `DESCRIZIONE`, `PZCART`, `IDIVA`, `IDFAMASS`) VALUES (?, ?, ?, ?, ?);";
			stm = conn.prepareStatement(sql);
			stm.setString(1, article.getCodArt());
			stm.setString(2, article.getDescrizione());
			stm.setInt(3, article.getPzCart());
			stm.setInt(4, article.getIdIva());
			stm.setInt(5, article.getIdFamAss());

			resultInsert = stm.executeUpdate();

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

		return resultInsert;

	}

	@Override
	public int update(Article article) {
		Connection conn = null;
		PreparedStatement stm = null;
		int resultUpdate = 0;
		String sql = null;

		conn = ConnectionConfig.getConnection();
		try {

			sql = "UPDATE articoli SET DESCRIZIONE= ?, PZCART= ?, IDIVA= ?, IDFAMASS= ? WHERE CODART= ?;";
			stm = conn.prepareStatement(sql);
			stm.setString(1, article.getDescrizione());
			stm.setInt(2, article.getPzCart());
			stm.setInt(3, article.getIdIva());
			stm.setInt(4, article.getIdFamAss());
			stm.setString(5, article.getCodArt());

			resultUpdate = stm.executeUpdate();

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

		return resultUpdate;
	}

	@Override
	public Article getArticleByCode(String codArt) {

		Connection conn = null;
		PreparedStatement stm = null;
		Article article = null;
		ResultSet rs = null;

		try {
			String sql = "select a.CODART,a.DESCRIZIONE,\r\n"
					+ " a.PZCART, i.DESCRIZIONE as DESCIVA, f.DESCRIZIONE as DESCFAMASSORT, a.IDIVA, a.IDFAMASS\r\n"
					+ "from articoli a join famassort f on a.IDFAMASS = f.ID \r\n"
					+ "join iva i on a.IDIVA = i.IDIVA WHERE CODART = ?";
			conn = ConnectionConfig.getConnection();
			stm = conn.prepareStatement(sql);

			stm.setString(1, codArt);
			rs = stm.executeQuery();

			while (rs.next()) {
				article = new Article();

				article.setCodArt(rs.getString("CODART"));
				article.setDescrizione(rs.getString("DESCRIZIONE"));
				article.setPzCart(rs.getInt("PZCART"));
				article.setIvaDesc(rs.getString("DESCIVA"));
				article.setFamAssDesc(rs.getString("DESCFAMASSORT"));
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
