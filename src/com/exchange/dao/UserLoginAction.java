package com.exchange.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;
import com.exchange.services.UserServices;

public class UserLoginAction {
	
	User loginUser = null;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User loginAction(User user){
		User localUser = new User();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		List<User> userList = query.list();
		for(User users:userList){
			if(users.getEmail().equals(user.getEmail())&&users.getPassword().equals(user.getPassword())){
				localUser = users;
			}
		}
		return localUser;
	}
}
