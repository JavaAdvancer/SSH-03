package com.exchange.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;


public class GetAllUserInfoDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User getAllUserInfoDao(Integer userId) {
		// TODO Auto-generated constructor stub
		User user = new User();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User u where u.id = :userId").setInteger("userId", userId);
		List<User> list = query.list();
		for(User users:list){
			user = users;
		}
		return user;
	}
}
