package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.model.FamAssort;
import it.objectmethod.supermarket.model.mapper.FamAssMapper;

public class FamAssortDaoImpl implements FamAssortDao {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<FamAssort> getFamAssort() {

		String sql = "SELECT * FROM famassort;";
		List<FamAssort> listFamAss = jdbcTemplate.query(sql, new FamAssMapper());
		return listFamAss;
	}

}
