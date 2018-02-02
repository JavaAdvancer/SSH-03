package com.exchange.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.services.EmailCheckServices;
import com.opensymphony.xwork2.ActionSupport;

public class EmailCheckAction extends ActionSupport{

	private String emailName;
	
	private EmailCheckServices emailCheckServices;
	
	
	public void setEmailCheckServices(EmailCheckServices emailCheckServices) {
		this.emailCheckServices = emailCheckServices;
	}


	public String getEmailName() {
		return emailName;
	}


	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}


	public void emailCheckAction() throws Exception{
		if(emailCheckServices.emailCheck(emailName)==true){
			System.out.println(emailName);
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("error");
			out.flush();
			out.close();
		}
	}
}
