package com.exchange.services;

import java.util.List;

import com.exchange.dao.GetSelfProductDao;
import com.exchange.entities.Product;

public class GetSelfProductService {

	private GetSelfProductDao getSelfProductDao;
	
	public void setGetSelfProductDao(GetSelfProductDao getSelfProductDao) {
		this.getSelfProductDao = getSelfProductDao;
	}
	
	public List<Product> getSelfProductService(){
		return getSelfProductDao.getSelfProductDao();
	}
}
