package com.nabid.assignment.service;

import com.nabid.assignment.entity.Developers;
import com.nabid.assignment.entity.Languages;

import java.util.List;

public interface LanguagesService {

    void save(Languages languages);
    void delete(Languages languages);
    Languages getLanguagesById(long id);
    List<Languages> findAll();
}