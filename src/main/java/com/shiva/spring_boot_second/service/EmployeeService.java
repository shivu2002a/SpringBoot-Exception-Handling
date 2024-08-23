package com.shiva.spring_boot_second.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shiva.spring_boot_second.exception.EmployeeException;
import com.shiva.spring_boot_second.model.Employee;
import com.shiva.spring_boot_second.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    private EmployeeRepository empRepo;

    public EmployeeService(EmployeeRepository repo) {
        this.empRepo = repo;
    }

    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    public Employee findById(int id) throws Exception {
        return empRepo.findById(id).orElseThrow(() -> new EmployeeException("Employee Not found"));
    }

	public void saveEmployee(Employee e) {
        empRepo.save(e);
	}

}
