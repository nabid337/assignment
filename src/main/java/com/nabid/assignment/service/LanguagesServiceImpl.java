package com.nabid.assignment.service;

import com.nabid.assignment.entity.Languages;
import com.nabid.assignment.repository.LanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguagesServiceImpl implements LanguagesService {
    @Autowired
    LanguagesRepo languagesRepo;
    @Override
    public void save(Languages languages) {
            languagesRepo.save(languages);
    }

    @Override
    public void delete(Languages languages) {

    }

    @Override
    public Languages getLanguagesById(long id) {
        return null;
    }



    @Override
    public List<Languages> findAll() {
        return languagesRepo.findAll();
    }
}