package com.shiva.spring_boot_second.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiva.spring_boot_second.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
