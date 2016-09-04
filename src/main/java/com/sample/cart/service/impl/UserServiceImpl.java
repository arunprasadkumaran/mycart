/**
 * 
 */
package com.sample.cart.service.impl;

import java.sql.SQLException;

import com.sample.cart.dao.UserDao;
import com.sample.cart.service.UserService;

/**
 * @author arun.prasad
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean isValidUser(String username, String password) throws SQLException {
		return userDao.isValidUser(username, password);
	}


}
