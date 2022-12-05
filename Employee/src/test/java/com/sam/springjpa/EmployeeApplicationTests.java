package com.sam.springjpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import com.sam.springjpa.entity.Employee;
import com.sam.springjpa.repository.EmployeeRepository;
import com.sam.springjpa.service.EmployeeService;

@SpringBootTest
class EmployeeApplicationTests {
	@Autowired
	ApplicationContext context;
	@Mock
	EmployeeRepository repo;
	@Autowired
	EmployeeService emps;
	
	@Test
	void contextLoads() {
		Employee emp=new Employee();
		emp.setEmpId(101L);
		emp.setFirstName("Aman");
		emp.setLastName("Anand");
		emp.setAge(21);
		emp.setSalary(2300d);
		List<Employee> emp1=new ArrayList<Employee>();
		emp1.add(emp);
		Mockito.when(repo.findAll()).thenReturn(emp1);
		
		Iterable<Employee> e1=emps.readAll();
		assertNotNull(e1);
		
		
		//repo.findAll().forEach(e->{
		//System.out.println(e.getFirstName());
		//});
		
		//emp.setAge(22);
		//repo.save(emp);
		
		//Optional<Employee> e2=repo.findById(101L);
		//System.out.println(e2);
		
		//repo.delete(emp);
		
		//Optional<Employee> e3=repo.findById(101L);
		//System.out.println(e3);
	}
}
