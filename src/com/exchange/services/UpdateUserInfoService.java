package com.exchange.services;

import com.exchange.dao.UpdateUserInfoDao;
import com.exchange.entities.User;

public class UpdateUserInfoService {

	private UpdateUserInfoDao updateUserInfoDao;

	public void setUpdateUserInfoDao(UpdateUserInfoDao updateUserInfoDao) {
		this.updateUserInfoDao = updateUserInfoDao;
	}
	
	public boolean updateUserInfoService(User user) {
		updateUserInfoDao.updateUserInfoDao(user);
		return true;
	}
}
