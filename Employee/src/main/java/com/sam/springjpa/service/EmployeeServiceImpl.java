package com.sam.springjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.springjpa.entity.Employee;
import com.sam.springjpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empr;
	
	@Override
	public Iterable<Employee> readAll() {
		// TODO Auto-generated method stub
		return empr.findAll();
	}
	
	@Override
	public Employee store(Employee emp) {
		// TODO Auto-generated method stub
		return empr.save(emp);
	}

	@Override
	public void remove(Long id,Employee emp) {
		// TODO Auto-generated method stub
		emp=empr.findById(id).get();
		empr.delete(emp);
		
	}

	@Override
	public Employee update(Long id,String fn) {
		// TODO Auto-generated method stub
		Employee em=empr.findById(id).get();
		em.setFirstName(fn);
		return empr.save(em);
	}
	
}
