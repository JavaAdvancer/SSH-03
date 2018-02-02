package com.exchange.services;

import java.util.List;

import com.exchange.dao.ShowAllProductDao;
import com.exchange.entities.Product;

public class ShowAllProductService {

	private ShowAllProductDao showAllProductDao;
	
	public void setShowAllProductDao(ShowAllProductDao showAllProductDao) {
		this.showAllProductDao = showAllProductDao;
	}
	
	public List<Product> showAllProductService(){
		return showAllProductDao.showAllProductDao();
	}
}
