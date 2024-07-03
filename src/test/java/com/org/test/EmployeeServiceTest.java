package com.org.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.org.entity.Employee;
import com.org.repository.EmployeeRepository;
import com.org.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	public void getAllEmployeeTest() {

		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("prince");
		e1.setDept("CS");
		e1.setSalary(33400);

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		when(employeeRepository.findAll()).thenReturn(empList);
		List<Employee> list = employeeService.getAllEmployee();
		assertEquals(1, list.size());
		verify(employeeRepository, times(1)).findAll();
	}

	@Test
	public void saveEmployeeTest() {
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("akash");
		e1.setDept("GS");
		e1.setSalary(63400);
		employeeService.saveEmployee(e1);

		verify(employeeRepository, times(1)).save(e1);
	}
}
