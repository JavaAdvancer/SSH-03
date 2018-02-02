package com.exchange.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Post;
import com.exchange.entities.User;

public class PostDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String postDao(Post post){
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)httpSession.getAttribute("userId");
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class, userId);
		post.setUser(user);
		session.save(post);
		session.close();
		return "success";
	}
}
