package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.modals.Employee;

@Service
public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findOne(int id);
	
	public void delete(int id);
	
	public void save(Employee employee);
	
	public List<Employee> sortByName();
}
