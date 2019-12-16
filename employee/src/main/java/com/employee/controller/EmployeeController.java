package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.modals.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employee")
	public void addEmployee(@Valid @RequestBody Employee employee){
		employeeService.save(employee);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findOne(@PathVariable("id") int id) {
		Employee employee = employeeService.findOne(id);
		if(employee==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		employeeService.delete(id);
	}
	
	@GetMapping("/employees/sorted")
	public List<Employee> getEmployeessortedByName(){
		return employeeService.sortByName();
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") int id,@Valid @RequestBody Employee updatedemployee) {
		Employee employee = employeeService.findOne(id);
		if(employee!=null) {
			employee.setName(updatedemployee.getName());
			employee.setDesignation(updatedemployee.getDesignation());
			employeeService.save(employee);
			return ResponseEntity.ok().body(employee);
		}
		return ResponseEntity.notFound().build();
	}
}
