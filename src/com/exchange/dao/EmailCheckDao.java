package com.exchange.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class EmailCheckDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean emailCheckDao(String emailName){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User u where u.email = :emailName").setString("emailName",emailName);
		List<User> userList = query.list();
		System.out.println(userList.isEmpty());
		if(userList.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
