package com.exchange.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Post;
import com.exchange.services.PostService;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport {

	private String title;
	private String content;
	private PostService postService;

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void postAction() throws Exception {
		Post post = new Post(title, content);
		if (postService.postService(post) == "success") {
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("error");
			out.flush();
			out.close();
		}
	}
}
