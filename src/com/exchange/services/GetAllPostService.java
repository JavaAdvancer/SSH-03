package com.exchange.services;

import java.util.List;

import com.exchange.dao.GetAllPostDao;
import com.exchange.entities.Post;

public class GetAllPostService {

	private GetAllPostDao getAllPostDao;
	
	public void setGetAllPostDao(GetAllPostDao getAllPostDao) {
		this.getAllPostDao = getAllPostDao;
	}
	
	public List<Post> getAllPostService(){
		return getAllPostDao.getAllPostDao();
	}
}
