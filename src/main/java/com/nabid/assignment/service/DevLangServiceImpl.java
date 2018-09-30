package com.nabid.assignment.service;

import com.nabid.assignment.entity.DevLang;
import com.nabid.assignment.repository.DevLangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevLangServiceImpl implements DevLangService {

    @Autowired
    DevLangRepo devLangRepo;
    @Override
    public void save(DevLang devLang) {
        devLangRepo.save(devLang);
    }

    @Override
    public List<DevLang> findAll() {
        return devLangRepo.findAll();
    }

    @Override
    public void delete(DevLang devLang) {
        devLangRepo.delete(devLang);
    }
}
