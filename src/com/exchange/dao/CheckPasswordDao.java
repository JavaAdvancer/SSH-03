package com.exchange.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class CheckPasswordDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String checkPasswordDao(String password) {
		Session session = sessionFactory.openSession();
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)httpSession.getAttribute("userId");
		User user = (User)session.get(User.class,userId);
		if(user.getPassword().equals(password)){
			
			return "true";
		}else{
			return "false";
		}
	}
}
