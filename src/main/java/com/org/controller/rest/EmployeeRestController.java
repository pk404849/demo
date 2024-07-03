package com.org.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.Employee;
import com.org.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		String message = "";
		if (employee.getId() == 0) {
			message = "Employee object created.";
		} else {
			message = "Employee object updated.";
		}
		return ResponseEntity.ok(message);
	}

	@GetMapping(value = "/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable(name = "empId") Integer empId) {
		Employee employee = employeeService.getEmployeeById(empId);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping(value = "/{empId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable(name = "empId") Integer empId) {
		employeeService.deleteEmployeeById(empId);
		String message = "Employee record deleted successfully";
		return ResponseEntity.ok(message);
	}

	@GetMapping
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> employeeList = employeeService.getAllEmployee();
		return ResponseEntity.ok(employeeList);
	}

}
