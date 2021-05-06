package com.example.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employees.entity.Employee;
import com.example.employees.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		employeeRepo.save(employee);
		return new ResponseEntity<>(employee.getEmployeeName(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employee/{id}")
	public List<Employee> deleteEmployee(@PathVariable Integer id){
		try {
			employeeRepo.deleteById(id);	
		}catch(Exception exp) {
			log.info("Expcetion occured while deleting record {}", id);
		}
		log.info("Record deleted successfully {}", id);
		return employeeRepo.findAll();
	}
	
}
