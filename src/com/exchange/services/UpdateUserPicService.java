package com.exchange.services;

import com.exchange.dao.UpdateUserPicDao;

public class UpdateUserPicService {

	private UpdateUserPicDao updateUserPicDao;
	
	public void setUpdateUserPicDao(UpdateUserPicDao updateUserPicDao) {
		this.updateUserPicDao = updateUserPicDao;
	}
	public String updateUserPicService(String location){
		if(updateUserPicDao.updateUserPicDao(location)=="success"){
			
			return "success";
		}else{
			return "error";
		}
	}
}
