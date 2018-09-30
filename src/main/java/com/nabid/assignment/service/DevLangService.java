package com.nabid.assignment.service;

import com.nabid.assignment.entity.DevLang;

import java.util.List;

public interface DevLangService {

    void save(DevLang devLang);
    List<DevLang> findAll();
    void delete(DevLang devLang);
}
