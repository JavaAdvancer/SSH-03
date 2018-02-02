package com.exchange.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	public void logoutAction() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("userEmail");
		session.removeAttribute("userId");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print("success");
	}
}
