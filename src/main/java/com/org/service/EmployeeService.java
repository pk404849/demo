package com.org.service;

import java.util.List;

import com.org.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public Employee getEmployeeById(Integer empId);

	public void deleteEmployeeById(Integer empId);

	public List<Employee> getAllEmployee();
}
