/**
 * 
 */
package com.sample.cart.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.cart.dao.ProductDao;
import com.sample.cart.service.ProductService;
import com.sample.cart.viewbean.Product;

/**
 * @author arun.prasad
 *
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public List<Product> getBookList(String category) throws SQLException {
		List<Product> productList = productDao.getBookList(category);
		return productList;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
