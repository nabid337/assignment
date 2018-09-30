package com.nabid.assignment.repository;

import com.nabid.assignment.entity.DevLang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevLangRepo extends JpaRepository<DevLang, Long> {
}
