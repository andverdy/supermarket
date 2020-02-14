package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.model.Iva;
import it.objectmethod.supermarket.model.mapper.IvaMapper;

public class IvaDaoImpl implements IvaDao {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Iva> getIva() {

		String sql = "SELECT * FROM iva;";
		List<Iva> listIva = jdbcTemplate.query(sql, new IvaMapper());
		return listIva;
	}

}
