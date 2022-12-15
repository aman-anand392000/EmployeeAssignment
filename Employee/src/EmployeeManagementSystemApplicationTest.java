package com.ems.employee;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ems.employee.entity.Employee;
import com.ems.employee.repository.EmployeeRepository;
import com.ems.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeManagementSystemApplicationTests {
	
	@Mock
	private EmployeeRepository repository;
	
	@InjectMocks
	private EmployeeService service;
	
	@Test
	public void getAllEmployeesTest(){
		when(repository.findAll()).thenReturn(Stream.of(new Employee(9831, "james", "Smith", 34, 350),new Employee(9841, "james", "Johnson", 36, 370)).collect(Collectors.toList()));
		assertEquals(2, service.getAllEmployees().size());
	}
	
	@Test
	public void addEmployeesTest(){
		Employee employee = new Employee(9991, "Aman", "Anand", 23, 360);
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.addEmployee(employee));
	}
	
	@Test
	public void removeEmployeesTest(){
		long empId = 9991;
		service.removeEmployee(empId);
		verify(repository,times(1)).deleteById(empId);
	}
	
	@Test
	public void updateEmployeesTest(){
		Employee employee = new Employee(999l, "Aman", "Anand", 23, 360);
		when(repository.save(employee)).thenReturn(employee);		
		Employee employee2 = new Employee(999l, "Ram", "Kumar", 36, 360);
		assertEquals(employee, service.updateEmployee(employee2));
	}
