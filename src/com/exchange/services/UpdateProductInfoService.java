package com.exchange.services;

import com.exchange.dao.UpdateProductInfoDao;
import com.exchange.entities.Product;

public class UpdateProductInfoService {

	private UpdateProductInfoDao updateProductInfoDao;
	
	public void setUpdateProductInfoDao(UpdateProductInfoDao updateProductInfoDao) {
		this.updateProductInfoDao = updateProductInfoDao;
	}
	public String updateProductInfoService(Product product){
		if(updateProductInfoDao.updateProductInfoDao(product)=="success"){
			
			return "success";
		}else {
			return "error";
		}
	}
}
