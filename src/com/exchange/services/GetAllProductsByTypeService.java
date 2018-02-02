package com.exchange.services;

import java.util.List;

import com.exchange.dao.GetAllProductsByTypeDao;
import com.exchange.entities.Product;

public class GetAllProductsByTypeService {

	private GetAllProductsByTypeDao getAllProductsByTypeDao;
	
	public void setGetAllProductsByTypeDao(GetAllProductsByTypeDao getAllProductsByTypeDao) {
		this.getAllProductsByTypeDao = getAllProductsByTypeDao;
	}
	
	public List<Product> getAllProductsByTypeService(String type){
		return getAllProductsByTypeDao.getAllProductsByTypeDao(type);
	}
}
