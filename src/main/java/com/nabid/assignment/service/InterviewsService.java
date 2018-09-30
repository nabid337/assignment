package com.nabid.assignment.service;

import com.nabid.assignment.entity.Developers;
import com.nabid.assignment.entity.Interviews;

import java.util.List;

public interface InterviewsService {
    long save(Interviews interviews);
    void delete(Interviews interviews);
    Interviews getDevelopersById(long id);
    List<Interviews> findAll();
    void deleteInterview(long id);
    List<Interviews> findByIsDeleted();

}