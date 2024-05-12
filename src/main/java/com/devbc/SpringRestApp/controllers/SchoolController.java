package com.devbc.SpringRestApp.controllers;

import com.devbc.SpringRestApp.entities.School;
import com.devbc.SpringRestApp.repositories.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        schoolRepository.save(school);
        return school;
    }

    @GetMapping("/schools")
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }
}
