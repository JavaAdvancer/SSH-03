package com.exchange.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Product;
import com.exchange.services.UpdateProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadProductInfoAction extends ActionSupport {
	private String name;
	private String title;
	private String detail;
	private String budgetTime;
	private Double budgetPrice;
	private String category;
	private File picture;
	private String pictureFileName;
	private UpdateProductInfoService updateProductInfoService;
	
	public void setUpdateProductInfoService(UpdateProductInfoService updateProductInfoService) {
		this.updateProductInfoService = updateProductInfoService;
	}
	
	
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setBudgetTime(String budgetTime) {
		this.budgetTime = budgetTime;
	}

	public void setBudgetprice(Double budgetPrice) {
		this.budgetPrice = budgetPrice;
	}

	public void setCategory(String category) {
		if(category.equals("book")){
			this.category="书籍资料";
		}
		if(category.equals("gym")){
			this.category="健身器材";
		}
		if(category.equals("shampoo")){
			this.category="洗化用品";
		}
		if(category.equals("digital")){
			this.category="电子数码";
		}
		if(category.equals("computer")){
			this.category="电脑配件";
		}
		if(category.equals("clothes")){
			this.category="上衣外套";
		}
		if(category.equals("trousers")){
			this.category="裤装鞋类";
		}
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String uploadProductInfoAction() throws Exception {
		// TODO Auto-generated method stub
		String realPath = ServletActionContext.getServletContext().getRealPath("\\upload\\images");
		String location = realPath+"\\"+pictureFileName;
		if(picture!=null){
			File saveFile = new File(new File(realPath),pictureFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(picture, saveFile);
		}
		Product product = new Product(name, title, detail, budgetTime, budgetPrice, category, location);
		if(updateProductInfoService.updateProductInfoService(product)=="success"){
			return "success";
		}else{
			return "error";
		}
	}
}
