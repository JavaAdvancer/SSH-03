package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.jni.Proc;

import com.exchange.entities.Product;
import com.exchange.services.GetAllProductsByTypeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAllProductsByType {

	private String type;
	
	private GetAllProductsByTypeService getAllProductsByTypeService;
	
	public void setGetAllProductsByTypeService(GetAllProductsByTypeService getAllProductsByTypeService) {
		this.getAllProductsByTypeService = getAllProductsByTypeService;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void getAllProductsByType() throws IOException{
		List<Product> lists = getAllProductsByTypeService.getAllProductsByTypeService(type);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for(Product p:lists){
			jsonObject.put("name", p.getName());
			jsonObject.put("title", p.getTitle());
			jsonObject.put("detail", p.getDetail());
			jsonArray.add(jsonObject);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
		out.flush();
		out.close();
	}
}
