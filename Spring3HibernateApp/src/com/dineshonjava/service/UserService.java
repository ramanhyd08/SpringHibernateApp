package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.model.Employee;
import com.dineshonjava.model.LoginBean;

/**
 * @author Dinesh Rajput
 *
 */
public interface UserService {
	public LoginBean ValidateUser(LoginBean loginBean);
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
