package com.nabid.assignment.service;

import com.nabid.assignment.entity.DevProg;
import com.nabid.assignment.repository.DevProgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevProgServiceImpl implements DevProgService {

    @Autowired
    DevProgRepo devProgRepo;
    @Override
    public void save(DevProg devProg) {
        devProgRepo.save(devProg);
    }

    @Override
    public List<DevProg> findAll() {
        List<DevProg> devProgList = devProgRepo.findAll();
        return devProgList;
    }

    @Override
    public void delete(DevProg devProg) {
            devProgRepo.delete(devProg);
    }
}
