package com.nabid.assignment.repository;

import com.nabid.assignment.entity.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguagesRepo extends JpaRepository<Languages, Long> {
}