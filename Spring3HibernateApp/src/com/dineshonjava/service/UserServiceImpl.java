package com.dineshonjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.dao.UserDao;
import com.dineshonjava.model.Employee;
import com.dineshonjava.model.LoginBean;

/**
 * @author Dinesh Rajput
 *
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		userDao.addEmployee(employee);
	}
	
	public List<Employee> listEmployeess() {
		return userDao.listEmployeess();
	}

	public Employee getEmployee(int empid) {
		return userDao.getEmployee(empid);
	}
	
	public void deleteEmployee(Employee employee) {
		userDao.deleteEmployee(employee);
	}

	@Override
	public LoginBean ValidateUser(LoginBean loginBean) {
		return userDao.validateUser(loginBean);
		
	}

}
