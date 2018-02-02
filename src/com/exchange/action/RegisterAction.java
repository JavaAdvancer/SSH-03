package com.exchange.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.User;
import com.exchange.services.UserServices;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;


public class RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	
	private UserServices userServices;
	
	
	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}


	public void registerAction() throws Exception {
		// TODO Auto-generated method stub
		User user = new User(email,password);
		userServices.save(user);
		JSONObject jsonObject = JSONObject.fromObject(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		out.close();
	}
}
