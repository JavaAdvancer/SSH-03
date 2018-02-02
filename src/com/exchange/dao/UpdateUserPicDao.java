package com.exchange.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class UpdateUserPicDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public String updateUserPicDao(String location){
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)httpSession.getAttribute("userId");
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class, userId);
		user.setPicture(location);
		session.saveOrUpdate(user);
		session.flush();
		return "success";
	}
}
