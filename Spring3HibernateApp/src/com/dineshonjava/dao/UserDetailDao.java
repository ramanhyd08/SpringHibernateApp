package com.dineshonjava.dao;


import java.sql.Blob;
import java.util.List;

import com.dineshonjava.model.UserDetail;

public interface UserDetailDao {
	
	public void addUserDetail(UserDetail user);

	public List<UserDetail> getUser(UserDetail userdetail);

	public List<UserDetail> getUser();

	public  void update(int id);

	public  void deleteByID(String id);

	public byte[] getUserdetailasByID(int id);

	public Object getUserByName(String userName);

	

}