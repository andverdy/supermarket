package it.objectmethod.supermarket.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.supermarket.model.Iva;

public class IvaMapper implements RowMapper<Iva> {

	@Override
	public Iva mapRow(ResultSet rs, int rowNum) throws SQLException {
		Iva iva = new Iva();
		iva.setIdIva(rs.getInt("IDIVA"));
		iva.setDescrizione(rs.getString("DESCRIZIONE"));
		return iva;
	}

}
