package com.dineshonjava.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.dao.UserDetailDao;
import com.dineshonjava.model.LoginBean;
import com.dineshonjava.model.UserDetail;

@Service("UserDataDetailService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDataDetailServiceImpl implements UserDataDetailService{

	
	@Autowired
	private UserDetailDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUserDetail(UserDetail userdetail) {
		userDao.addUserDetail(userdetail);
		
	}

	
	public List<UserDetail> getUser(UserDetail userdetail) {
		
		
			return userDao.getUser(userdetail);
		
	}

	public List<UserDetail> getUser() {
		
		
		return userDao.getUser();
	
}


	
	public void update(int id) {
		
		userDao.update( id);
	}


	
	public void deleteByID(String id) {
		
	 userDao.deleteByID( id);
	}


	@Override
	public byte[] getUserdetailasByID(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserdetailasByID(id);
	}


	@Override
	public Object getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(userName);
	}


	
}
