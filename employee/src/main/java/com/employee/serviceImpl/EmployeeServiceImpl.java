package com.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.modals.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	public void delete(int id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee findOne(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent())
			return employee.get();
		else
			return null;
	}
	
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}
	
	public List<Employee> sortByName() {
		return employeeRepo.findAllByOrderByNameAsc();
	}
}
