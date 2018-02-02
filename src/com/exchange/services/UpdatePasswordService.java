package com.exchange.services;

import com.exchange.dao.UpdatePasswordDao;

public class UpdatePasswordService {

	private UpdatePasswordDao updatePasswordDao;
	
	public void setUpdatePasswordDao(UpdatePasswordDao updatePasswordDao) {
		this.updatePasswordDao = updatePasswordDao;
	}
	
	public String updatePasswordService(String password){
		if(updatePasswordDao.updatePasswordDao(password)=="true"){
			return "true";
		}else{
			return "false";
		}
	}
}
