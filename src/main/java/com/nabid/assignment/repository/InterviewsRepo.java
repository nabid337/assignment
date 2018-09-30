package com.nabid.assignment.repository;

import com.nabid.assignment.entity.Interviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterviewsRepo extends JpaRepository<Interviews, Long> {


    @Query("SELECT u FROM Interviews u WHERE u.isDeleted = 0")
    List<Interviews> findByIsDeleted();
}