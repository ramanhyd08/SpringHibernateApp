package com.dineshonjava.service;


import java.sql.Blob;
import java.util.List;

import com.dineshonjava.model.LoginBean;
import com.dineshonjava.model.UserDetail;

public interface UserDataDetailService {

	
	public void addUserDetail(UserDetail userdetail);
	public List<UserDetail> getUser(UserDetail userdetail);
	public List<UserDetail> getUser();
	public void update(int parameter);
	public void deleteByID(String parameter);
	public byte[] getUserdetailasByID(int id);
	//public Object getUser(LoginBean loginBeanPersistance);
	public Object getUserByName(String userName);

}
