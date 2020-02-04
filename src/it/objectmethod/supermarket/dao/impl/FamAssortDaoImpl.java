package it.objectmethod.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.supermarket.config.ConnectionConfig;
import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.model.FamAssort;

public class FamAssortDaoImpl implements FamAssortDao {


	@Override
	public List<FamAssort> getFamAssort() {
		
		FamAssort famAssort = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<FamAssort> listFamAssort = new ArrayList<>();

		try {
			conn = ConnectionConfig.getConnection();
			String sql = "SELECT * FROM famassort;;";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {

				famAssort = new FamAssort();
				famAssort.setId(rs.getInt("ID"));
				famAssort.setDescrizione(rs.getString("DESCRIZIONE"));

				listFamAssort.add(famAssort);

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

		return listFamAssort;
		
	}

}
