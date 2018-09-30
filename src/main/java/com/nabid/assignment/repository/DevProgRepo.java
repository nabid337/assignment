package com.nabid.assignment.repository;

import com.nabid.assignment.entity.DevProg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevProgRepo extends JpaRepository<DevProg, Long> {
}
