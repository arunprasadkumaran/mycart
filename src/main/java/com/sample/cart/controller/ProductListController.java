package com.sample.cart.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.cart.service.ProductService;
import com.sample.cart.viewbean.Product;

/**
 * @author arun.prasad
 *
 */
@Controller("productListController")
@RequestMapping("/browse")
public class ProductListController {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		List<Product> bookList = null;
		try {
			bookList = productService.getBookList("Books");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("book_catalog");
		model.addObject("bookList", bookList);
		return model;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}