package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CheckIsLoginAction extends ActionSupport{

	public void checkIsLoginAction() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId")==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("error");
			out.flush();
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
		}
	}
}
