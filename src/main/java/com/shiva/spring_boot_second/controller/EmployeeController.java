package com.shiva.spring_boot_second.controller;

import java.net.http.HttpHeaders;
import java.security.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.spring_boot_second.exception.EmployeeException;
import com.shiva.spring_boot_second.model.Employee;
import com.shiva.spring_boot_second.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
// @ControllerAdvice // Makes it a global exception handler class. Not needed for method level exc handling
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    } 
    
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getMethodName() {
        return ResponseEntity.ok((empService.getAll()));
    }

    @GetMapping("/{id}")
    // @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Employee> getById(@PathVariable int id) throws Exception {
        Employee opt;
        // try {
            opt = empService.findById(id);
            return new ResponseEntity<>(opt, HttpStatus.FOUND);
        // } catch (Exception e) {
            // return new ResponseEntity<>("Not found", HttpStatus.FOUND);
        // }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee e) {
        empService.saveEmployee(e);
        return ResponseEntity.ok("Inserted");
    }
    
    
    
}
