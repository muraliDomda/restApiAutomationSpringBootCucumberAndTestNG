package com.sa.demo.controller;

import com.sa.demo.model.Employee;
import com.sa.demo.model.EmployeeOld;
import com.sa.demo.service.EmployeeService;
import com.sa.demo.service.EmployeeServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceOld employeeServiceOld;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    private EmployeeService employeeService;


    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id) {
        employeeService.deleteMappingById(id);
        return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") long id,@RequestBody Employee employee) {
        return new ResponseEntity<Employee>( employeeService.updateEmployeeById(id,employee),HttpStatus.OK);
    }

}
