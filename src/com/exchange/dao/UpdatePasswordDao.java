package com.exchange.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class UpdatePasswordDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String updatePasswordDao(String password){
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)httpSession.getAttribute("userId");
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class,userId);
		user.setPassword(password);
		session.saveOrUpdate(user);
		session.flush();
		return "true";
	}
}
