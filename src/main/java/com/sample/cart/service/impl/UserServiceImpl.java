/**
 * 
 */
package com.sample.cart.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.cart.dao.UserDao;
import com.sample.cart.service.UserService;

/**
 * @author arun.prasad
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean isValidUser(String username, String password) throws SQLException {
		boolean isValidUser = userDao.isValidUser(username, password);
		return isValidUser;
	}


}
