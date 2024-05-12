package com.devbc.SpringRestApp.repositories;

import com.devbc.SpringRestApp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //JPA allows you to use custom filters on methods. For example - findAllBy...and then append column name from model
    // with other predefined names like Containing, Like, etc...
    List<Student> findAllByFirstNameContaining(String firstName);
}
