package com.exchange.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Product;
import com.exchange.services.GetProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class GetProductInfoAction extends ActionSupport{

	private Integer id;
	private GetProductInfoService getProductInfoService;
	

	public void setGetProductInfoService(GetProductInfoService getProductInfoService) {
		this.getProductInfoService = getProductInfoService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void getProductInfoAction() throws Exception{
		Product product = getProductInfoService.getProductInfoService(id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", product.getId());
		jsonObject.put("name", product.getName());
		jsonObject.put("title", product.getTitle());
		jsonObject.put("detail", product.getDetail());
		jsonObject.put("budgetTime", product.getBudgetTime());
		jsonObject.put("budgetPrice", product.getBudgetPrice());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		out.close();
	}
}
