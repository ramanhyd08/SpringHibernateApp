package com.dineshonjava.dao;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Employee;
import com.dineshonjava.model.LoginBean;
import com.dineshonjava.model.UserDetail;

/**
 * @author Dinesh Rajput
 *
 */
@Repository("userDetailDao")
public class UserDetailDaoImpl implements UserDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUserDetail(UserDetail user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<UserDetail> getUser(UserDetail userdetail) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserDetail.class);
		cr.add(Restrictions.eq("loginBean", userdetail.getLoginBean()));
		return cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<UserDetail> getUser() {
	
		return sessionFactory.getCurrentSession().createCriteria(UserDetail.class).list();
	}

	public  void update(int id) {
		System.out.println(id);
		sessionFactory.getCurrentSession().createQuery("update  UserDetail set status='approved' WHERE id = "+id).executeUpdate();
		
		
	}

	
	public  void deleteByID(String id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM UserDetail WHERE id = "+id).executeUpdate();
		
	}

	@Override
	public byte[] getUserdetailasByID(int id) {
		UserDetail ud=(UserDetail) sessionFactory.getCurrentSession().get(UserDetail.class, id);
		return ud.getData();
	}

	@Override
	public List<Object> getUserByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
