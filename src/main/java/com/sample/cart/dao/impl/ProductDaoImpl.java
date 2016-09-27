/**
 * 
 */
package com.sample.cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sample.cart.dao.ProductDao;
import com.sample.cart.viewbean.Product;

/**
 * @author arun.prasad
 *
 */

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;

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

	public List<Product> getBookList(String category) throws SQLException {
		String query = "SELECT PRODUCT_ID, PRODUCT_NAME, PRICE FROM PRODUCT WHERE CATEGORY = ?";
		List<Product> productList = this.jdbcTemplate.query(query, new RowMapper<Product>() {
			public Product mapRow(ResultSet resultSet, int i) throws SQLException {
				Product product = new Product();
				product.setProductId((long) resultSet.getInt("PRODUCT_ID"));
				product.setProductName(resultSet.getString("PRODUCT_NAME"));
				product.setPrice((long) resultSet.getInt("PRICE"));
				return product;
			}
		}, category);
		return productList;
	}

}