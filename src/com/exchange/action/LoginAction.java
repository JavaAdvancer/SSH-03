package com.exchange.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.exchange.entities.User;
import com.exchange.services.UserLoginServices;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class LoginAction extends ActionSupport{

	User user = null;
	
	private String email;
	private String password;
	private UserLoginServices userLoginServices;
	
	
	public void setUserLoginServices(UserLoginServices userLoginServices) {
		this.userLoginServices = userLoginServices;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void loginAction() throws Exception{
		user = new User(email, password);
		User localUser = new User();
		localUser = userLoginServices.userLoginServices(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userEmail", localUser.getEmail());
		session.setAttribute("userId", localUser.getId());
		JSONObject jsonObject = JSONObject.fromObject(localUser);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		out.close();	
	}
}
