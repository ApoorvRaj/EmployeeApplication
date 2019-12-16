package com.employee.repository;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.modals.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	List <Employee> findAllByOrderByNameAsc();
}
