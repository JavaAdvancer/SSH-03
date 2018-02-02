package com.exchange.services;

import com.exchange.dao.DelSelfPostDao;

public class DelSelfPostService {

	private DelSelfPostDao delSelfPostDao;
	
	public void setDelSelfPostDao(DelSelfPostDao delSelfPostDao) {
		this.delSelfPostDao = delSelfPostDao;
	}
	public void delSelfPostService(int id){
		delSelfPostDao.delSelfPostDao(id);
	}
}
