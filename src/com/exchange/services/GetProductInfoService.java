package com.exchange.services;

import com.exchange.dao.GetProductInfoDao;
import com.exchange.entities.Product;

public class GetProductInfoService {

	private GetProductInfoDao getProductInfoDao;
	
	public void setGetProductInfoDao(GetProductInfoDao getProductInfoDao) {
		this.getProductInfoDao = getProductInfoDao;
	}
	
	public Product getProductInfoService(Integer id){
		return getProductInfoDao.getProductInfoDao(id);
	}
}
