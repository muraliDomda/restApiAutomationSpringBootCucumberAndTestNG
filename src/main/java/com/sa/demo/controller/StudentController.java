package com.sa.demo.controller;

import com.sa.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Murali", "Doma");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Murali", "Doma"));
        studentsList.add(new Student("Tom", "Bailley"));
        studentsList.add(new Student("Steev", "Jackson"));
        studentsList.add(new Student("Ram", "Sethu"));
        return studentsList;
    }


    @GetMapping("/student/{firstName}/{lastName}")
    public Student getStudent(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

    @GetMapping("/student/query")
    public Student getStudentQuery(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName){
        return new Student(firstName, lastName);
    }


}
