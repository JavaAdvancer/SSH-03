package com.exchange.services;

import com.exchange.dao.GetSellerInfoDao;
import com.exchange.entities.User;

public class GetSellerInfoService {

	private GetSellerInfoDao getSellerInfoDao;
	
	public void setGetSellerInfoDao(GetSellerInfoDao getSellerInfoDao) {
		this.getSellerInfoDao = getSellerInfoDao;
	}
	
	public User getSellerInfoService(Integer id){
		return getSellerInfoDao.getSellerInfoDao(id);
	}
}
