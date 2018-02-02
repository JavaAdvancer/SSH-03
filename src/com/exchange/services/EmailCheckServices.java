package com.exchange.services;

import com.exchange.dao.EmailCheckDao;

public class EmailCheckServices {

	private EmailCheckDao emailCheckDao;

	public void setEmailCheckDao(EmailCheckDao emailCheckDao) {
		this.emailCheckDao = emailCheckDao;
	}
	
	public boolean emailCheck(String emailName){
		if(emailCheckDao.emailCheckDao(emailName)==true){
			return true;
		}else{
			return false;
		}
	}
}
