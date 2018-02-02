package com.exchange.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Post;
import com.exchange.services.SaveSelfPostService;

public class SaveSelfPostAction {

	private Integer id;
	private String title;
	private String content;
	private SaveSelfPostService saveSelfPostService;
	
	public void setSaveSelfPostService(SaveSelfPostService saveSelfPostService) {
		this.saveSelfPostService = saveSelfPostService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void saveSelfPostAction() throws Exception{
		Post post = new Post(id, title, content);
		saveSelfPostService.saveSelfPostService(post);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print("success");
		out.flush();
		out.close();
	}
}
