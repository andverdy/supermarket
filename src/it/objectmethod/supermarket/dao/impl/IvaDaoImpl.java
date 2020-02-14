package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.model.Iva;

public class IvaDaoImpl extends NamedParameterJdbcDaoSupport implements IvaDao {

	@Override
	public List<Iva> getIva() {

		String sql = "SELECT * FROM iva;";
		List<Iva> listIva = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Iva>(Iva.class));
		return listIva;
	}

}
