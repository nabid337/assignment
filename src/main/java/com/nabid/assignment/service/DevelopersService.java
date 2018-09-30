package com.nabid.assignment.service;

import com.nabid.assignment.entity.DeveloperDetail;
import com.nabid.assignment.entity.Developers;

import java.util.List;
import java.util.Optional;

public interface DevelopersService {
    long save(Developers developers);
    void deleteDeveloper(long id);
    Optional<Developers> getDevelopersById(long id);
    List<Developers> findAll();
    List<Object[]> getDevDetails(long id);
    Optional<Developers> findById(long id);
    List<Object[]> getDevOneProgLang(long progLangId);
    List<Object[]> getDevOneProgOneLang(long progLangId, String code);
    List<Object[]> getDevTwoProgOneLang(long progLangId1,long progLangId2, String code);
    List<Object[]> getDevTwoProg(long progLangId1,long progLangId2);

}
