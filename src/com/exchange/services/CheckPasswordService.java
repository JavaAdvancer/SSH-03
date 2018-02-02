package com.exchange.services;

import com.exchange.dao.CheckPasswordDao;

public class CheckPasswordService {

	private CheckPasswordDao checkPasswordDao;
	
	public void setCheckPasswordDao(CheckPasswordDao checkPasswordDao) {
		this.checkPasswordDao = checkPasswordDao;
	}
	
	public String checkPasswordDao(String password){
		if(checkPasswordDao.checkPasswordDao(password)=="true"){
			return "true";
		}else{
			return "false";
		}
	}
}
