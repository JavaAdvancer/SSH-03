package com.exchange.services;

import com.exchange.dao.SaveSelfPostDao;
import com.exchange.entities.Post;

public class SaveSelfPostService {

	private SaveSelfPostDao saveSelfPostDao;
	
	public void setSaveSelfPostDao(SaveSelfPostDao saveSelfPostDao) {
		this.saveSelfPostDao = saveSelfPostDao;
	}
	
	public void saveSelfPostService(Post post){
		saveSelfPostDao.saveSelfPostDao(post);
	}
}
