package com.devbc.SpringRestApp.controllers;

import com.devbc.SpringRestApp.entities.Student;
import com.devbc.SpringRestApp.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        studentRepository.save(student);

        return student;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id
    ) {
       return studentRepository.findById(id).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name") String name
    ) {
       return studentRepository.findAllByFirstNameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id) {
        studentRepository.deleteById(id);
    }
}
