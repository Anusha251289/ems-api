package com.example.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
