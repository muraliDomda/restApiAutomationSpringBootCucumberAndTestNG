package com.sa.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Entity
@Table(name="employee")
@Component
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

}
