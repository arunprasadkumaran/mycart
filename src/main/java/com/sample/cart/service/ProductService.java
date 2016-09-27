package com.sample.cart.service;

import java.sql.SQLException;
import java.util.List;

import com.sample.cart.viewbean.Product;

public interface ProductService {
	public List<Product> getBookList(String category) throws SQLException;
}
