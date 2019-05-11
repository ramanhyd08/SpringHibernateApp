package com.dineshonjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="User_Detail")
public class UserDetail {

	@Id
    
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
    
    private String loginBean;
    
    private String textmessage;
    
    private String status="submitted";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(String loginBean) {
		this.loginBean = loginBean;
	}

	public String getTextmessage() {
		return textmessage;
	}

	public void setTextmessage(String textmessage1) {
		textmessage = textmessage1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
