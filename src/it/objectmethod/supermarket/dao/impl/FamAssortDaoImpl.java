package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.model.FamAssort;

public class FamAssortDaoImpl extends NamedParameterJdbcDaoSupport implements FamAssortDao {

	@Override
	public List<FamAssort> getFamAssort() {

		String sql = "SELECT * FROM famassort;";
		List<FamAssort> listFamAss = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<FamAssort>(FamAssort.class));
		return listFamAss;
	}

}
