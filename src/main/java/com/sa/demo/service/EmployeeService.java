package com.sa.demo.service;

import com.sa.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();

    Employee getEmployeeById(long id);

    void deleteMappingById(long id);

    Employee updateEmployeeById(long id, Employee employee);
}
