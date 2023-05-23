package com.sa.demo.service.impl;

import com.sa.demo.exception.ResourceNotFoundException;
import com.sa.demo.model.Employee;
import com.sa.demo.repository.EmployeeRepository;
import com.sa.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));

    }

    @Override
    public void deleteMappingById(long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
         employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployeeById(long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
}
