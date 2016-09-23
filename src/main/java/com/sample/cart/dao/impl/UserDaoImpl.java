/**
 * 
 */
package com.sample.cart.dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.cart.dao.UserDao;

/**
 * @author arun.prasad
 *
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * public boolean isValidUser(String username, String password) throws
	 * SQLException { String query = "Select count(1) from CUSTOMER where NAME =
	 * ? and password = ?"; PreparedStatement pstmt =
	 * dataSource.getConnection().prepareStatement(query); pstmt.setString(1,
	 * username); pstmt.setString(2, password); ResultSet resultSet =
	 * pstmt.executeQuery(); if (resultSet.next()) return (resultSet.getInt(1) >
	 * 0); else return false; }
	 **/

	public boolean isValidUser(String username, String password) throws SQLException {
		String query = "Select count(1) from CUSTOMER where NAME = ? and password = ?";
		int rowCount = this.jdbcTemplate.queryForObject(query, Integer.class);

		return rowCount == 0 ? false : true;
	}

}