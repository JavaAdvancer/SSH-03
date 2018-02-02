package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.services.DelSelfPostService;

public class DelSelfPostAction {

	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	private DelSelfPostService delSelfPostService;
	
	public void setDelSelfPostService(DelSelfPostService delSelfPostService) {
		this.delSelfPostService = delSelfPostService;
	}
	
	public void delSelfPostAction() throws Exception{
		delSelfPostService.delSelfPostService(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print("success");
		out.flush();
	}
}
