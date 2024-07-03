package com.org.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Employee;
import com.org.repository.EmployeeRepository;
import com.org.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> optional = employeeRepository.findById(empId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		employeeRepository.deleteById(empId);

	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
}
