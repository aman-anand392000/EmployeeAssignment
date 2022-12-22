package com.sam.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sam.springboot.controller.EmployeeController;
import com.sam.springboot.entity.Employee;
import com.sam.springboot.repository.EmployeeRepository;
import com.sam.springboot.service.EmployeeServiceImpl;

@SpringBootTest
class SortingDetailsInEmployeeApplicationTests {
	@Autowired
	EmployeeController con;
	
	@Mock
	EmployeeRepository repo;
	
	@InjectMocks
	EmployeeServiceImpl serv;
	
	List<Employee> lemp=new ArrayList<Employee>();
	
	List<Employee> lemp1=new ArrayList<Employee>();
	
	@BeforeEach
	void setUp()
	{
		Employee emp1=new Employee();
		emp1.setEmpId(982l);
		emp1.setFirstName("Vijay");
		emp1.setLastName("Kumar");
		emp1.setAge(32);
		emp1.setSalary(360d);
		lemp.add(emp1);

		Employee emp2=new Employee();
		emp2.setEmpId(983l);
		emp2.setFirstName("James");
		emp2.setLastName("Johnson");
		emp2.setAge(34);
		emp2.setSalary(350d);
		lemp.add(emp2);
		
		Employee emp3=new Employee();
		emp3.setEmpId(984l);
		emp3.setFirstName("James");
		emp3.setLastName("Smith");
		emp3.setAge(36);
		emp3.setSalary(370);
		lemp.add(emp3);
	}
	
	@Test
	void sortByName() {
		Mockito.when(repo.findAll()).thenReturn(lemp);
		lemp1=serv.sortName();
		//when(serv.sortName()).thenReturn(Stream.of(lemp).collect(Collectors.toList()));
		
		assertEquals("James Johnson", lemp1.get(0).getFirstName()+" "+lemp1.get(0).getLastName());	
	}
	
	@Test
	void sortByAge() {
		Mockito.when(repo.findAll()).thenReturn(lemp);
		lemp1=serv.sortAge();
		//when(serv.sortName()).thenReturn(Stream.of(lemp).collect(Collectors.toList()));
		
		assertEquals(32, lemp1.get(0).getAge());	
	}
}
