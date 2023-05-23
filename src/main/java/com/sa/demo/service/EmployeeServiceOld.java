package com.sa.demo.service;

import com.sa.demo.model.Address;
import com.sa.demo.model.EmployeeOld;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceOld {
    //Entity
    private List<EmployeeOld> employeeLists = new ArrayList<>(List.of(
            EmployeeOld.builder()
                    .id(1)
                    .email("murali@test.com")
                    .name("murali")
                    .phone(987654310)
                    .address(Address.builder().city("Birmingham").country("UK").street("New Hall Street").build())
                    .build(),
            EmployeeOld.builder().email("domda@test.com")
                    .id(2)
                    .name("domda")
                    .phone(123456789)
                    .address(Address.builder().city("Tirupathi").country("India").street("Pakala").build())
                    .build(),
            EmployeeOld.builder()
                    .id(3)
                    .email("MuraliD@test.com")
                    .name("MuraliD")
                    .phone(727734768)
                    .address(Address.builder().city("Bangalore").country("India").street("JCRLayout").build())
                    .build()
    ));

    public List<EmployeeOld> getAllEmployees() {
        return employeeLists;
    }

    public EmployeeOld getEmployeeById(int id) {
        return employeeLists.stream()
                .filter(x -> x.getId() == id)
                .findFirst().get();
    }

    public List<EmployeeOld> addEmployee(EmployeeOld employee) {
        employeeLists.add(employee);
        return employeeLists;
    }


    public EmployeeOld updateEmployee(int id, EmployeeOld employee) {
        return employeeLists.stream()
                .filter(x -> x.getId() == id)
                .peek(o -> o.setName(employee.getName()))
                .peek(o -> o.setEmail(employee.getEmail()))
                .peek(o -> o.setPhone(employee.getPhone()))
                .findFirst().get();
    }

    public List<EmployeeOld> deleteEmployee(int id) {
        employeeLists.removeIf(x -> x.getId() == id);
        return employeeLists;
    }
}
