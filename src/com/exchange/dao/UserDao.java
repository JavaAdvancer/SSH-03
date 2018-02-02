package com.exchange.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class UserDao {

	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void save(User user){
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();	
	}
}
