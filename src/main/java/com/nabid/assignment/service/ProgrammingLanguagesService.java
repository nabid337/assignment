package com.nabid.assignment.service;

import com.nabid.assignment.entity.ProgrammingLanguages;

import java.util.List;

public interface ProgrammingLanguagesService {

    void save(ProgrammingLanguages programmingLanguages);
    void delete(ProgrammingLanguages programmingLanguages);
    ProgrammingLanguages getProgrammingLanguagesById(long id);
    List<ProgrammingLanguages> findAll();
    List<Object[]> getNotUsedProgLang();
}