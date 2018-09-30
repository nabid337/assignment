package com.nabid.assignment.repository;

import com.nabid.assignment.entity.ProgrammingLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguagesRepo extends JpaRepository<ProgrammingLanguages , Long> {
}