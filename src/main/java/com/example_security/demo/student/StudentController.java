package com.example_security.demo.student;

import com.example_security.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static List<Student> studentsList = Arrays.asList(
            new Student(1,"James Bond"),
            new Student(2,"Maria Jones"),
            new Student(3,"Anna Smith")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(
            @PathVariable("studentId") int studentId
    ){
        // with stream
        Student student = studentsList.stream()
                .filter(student1 -> student1.getStudentId()==studentId)
                .findFirst()
                .orElseThrow(
                        ()-> new IllegalStateException(
                                        "Student " + studentId + " does not exists")
                );

        System.out.println(student);

        // simple way
//        Student student2 = studentsList.get(studentId);


        return student;
    }
}
