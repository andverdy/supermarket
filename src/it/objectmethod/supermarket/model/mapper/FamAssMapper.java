package it.objectmethod.supermarket.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.supermarket.model.FamAssort;

public class FamAssMapper implements RowMapper<FamAssort> {

	@Override
	public FamAssort mapRow(ResultSet rs, int rowNum) throws SQLException {
		FamAssort famAss = new FamAssort();
		famAss.setId(rs.getInt("ID"));
		famAss.setDescrizione(rs.getString("DESCRIZIONE"));
		return famAss;
	}

}
