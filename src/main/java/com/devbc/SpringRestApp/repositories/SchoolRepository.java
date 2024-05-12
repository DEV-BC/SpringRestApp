package com.devbc.SpringRestApp.repositories;

import com.devbc.SpringRestApp.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
