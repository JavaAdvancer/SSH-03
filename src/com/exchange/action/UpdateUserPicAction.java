package com.exchange.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.exchange.services.UpdateUserPicService;

public class UpdateUserPicAction {

	private File picture;
	private String pictureFileName;
	private UpdateUserPicService updateUserPicService;
	
	public void setUpdateUserPicService(UpdateUserPicService updateUserPicService) {
		this.updateUserPicService = updateUserPicService;
	}
	
	public void setPicture(File picture) {
		this.picture = picture;
	}


	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}


	public String updateUserPicAction() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath("\\upload\\images");
		String location = realPath+"\\"+pictureFileName;
		if(picture!=null){
			File saveFile = new File(new File(realPath),pictureFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(picture, saveFile);
		}
		if(updateUserPicService.updateUserPicService(location)=="success"){
			
			return "success";
		}else{
			return "error";
		}
	}
}
