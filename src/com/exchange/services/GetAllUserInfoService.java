package com.exchange.services;

import com.exchange.dao.GetAllUserInfoDao;
import com.exchange.entities.User;

public class GetAllUserInfoService {

	private GetAllUserInfoDao getAllUserInfoDao;

	public void setGetAllUserInfoDao(GetAllUserInfoDao getAllUserInfoDao) {
		this.getAllUserInfoDao = getAllUserInfoDao;
	}
	
	public User getAllUserInfoService(Integer userId) {
		// TODO Auto-generated constructor stub
		User user = null;
		user = getAllUserInfoDao.getAllUserInfoDao(userId);
		return user;
	}
}
