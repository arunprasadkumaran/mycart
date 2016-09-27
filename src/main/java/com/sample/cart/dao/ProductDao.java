package com.sample.cart.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.cart.viewbean.Product;

public interface ProductDao {
	public List<Product> getBookList(String category) throws SQLException;

}
