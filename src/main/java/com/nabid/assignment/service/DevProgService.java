package com.nabid.assignment.service;

import com.nabid.assignment.entity.DevProg;

import java.util.List;

public interface DevProgService {
    void save(DevProg devProg);
    List<DevProg> findAll();
    void delete(DevProg devProg);
}
