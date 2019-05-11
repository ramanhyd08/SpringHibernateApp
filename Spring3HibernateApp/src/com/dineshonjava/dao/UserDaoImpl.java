package com.dineshonjava.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Employee;
import com.dineshonjava.model.LoginBean;

/**
 * @author Dinesh Rajput
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeess() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
	}

	@Override
	public LoginBean validateUser(LoginBean loginBean) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(LoginBean.class);
		cr.add(Restrictions.eq("userName", loginBean.getUserName()));
		return (LoginBean) cr.list().get(0);
		
	}

}
