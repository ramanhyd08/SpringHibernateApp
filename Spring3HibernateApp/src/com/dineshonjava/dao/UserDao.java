package com.dineshonjava.dao;

import java.util.List;

import com.dineshonjava.model.Employee;
import com.dineshonjava.model.LoginBean;

/**
 * @author Dinesh Rajput
 *
 */
public interface UserDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);

	public LoginBean validateUser(LoginBean loginBean);
}
