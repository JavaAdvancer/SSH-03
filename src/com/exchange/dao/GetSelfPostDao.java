package com.exchange.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Post;

public class GetSelfPostDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Post> getSelfPostDao(){
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)httpSession.getAttribute("userId");
		Session session = sessionFactory.openSession();
		List<Post> list = session.createQuery("from Post p where p.user.id = :userId")
				.setInteger("userId", userId)
				.list();
		return list;
		
	}
}
