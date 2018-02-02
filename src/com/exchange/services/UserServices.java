package com.exchange.services;

import com.exchange.dao.UserDao;
import com.exchange.entities.User;

public class UserServices {

	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void save(User user){
		userDao.save(user);
	}
}
