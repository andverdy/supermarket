package it.objectmethod.supermarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.supermarket.config.ConnectionConfig;
import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.model.Iva;

public class IvaDaoImpl implements IvaDao {

	@Override
	public List<Iva> getIva() {

		Iva iva = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Iva> listIva = new ArrayList<>();

		try {
			conn = ConnectionConfig.getConnection();
			String sql = "SELECT * FROM iva;";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {

				iva = new Iva();
				iva.setIdIva(rs.getInt("IDIVA"));
				iva.setDescrizione(rs.getString("DESCRIZIONE"));

				listIva.add(iva);

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

		return listIva;
	}


}
