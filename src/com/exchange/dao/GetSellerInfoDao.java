package com.exchange.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class GetSellerInfoDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User getSellerInfoDao(Integer id){
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class, id);
		return user;
	}
}
