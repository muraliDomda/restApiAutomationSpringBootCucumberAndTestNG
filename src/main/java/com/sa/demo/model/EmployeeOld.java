package com.sa.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class EmployeeOld {

    private int id;
    private String name;
    private Address address;
    private String email;
    private int phone;



}
