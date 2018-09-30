package com.nabid.assignment.service;

import com.nabid.assignment.entity.ProgrammingLanguages;
import com.nabid.assignment.repository.ProgrammingLanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public class ProgrammingLanguagesServiceImpl implements ProgrammingLanguagesService {

    @Autowired
    ProgrammingLanguagesRepo programmingLanguagesRepo;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void save(ProgrammingLanguages programmingLanguages) {
        programmingLanguagesRepo.save(programmingLanguages);
    }

    @Override
    public void delete(ProgrammingLanguages programmingLanguages) {

    }

    @Override
    public ProgrammingLanguages getProgrammingLanguagesById(long id) {
        return null;
    }



    @Override
    public List<ProgrammingLanguages> findAll() {
        return programmingLanguagesRepo.findAll();
    }

    @Override
    public List<Object[]> getNotUsedProgLang() {
        List<Object[]> list = null;
        list = entityManager.createNativeQuery("select * from programming_languages where programming_languages.prog_lang_id not in\n" +
                "(\n" +
                "select programming_languages.prog_lang_id as prog_lang_id\n" +
                "from developers\n" +
                "left join dev_prog\n" +
                "on dev_prog.dev_id = developers.dev_id\n" +
                "left join programming_languages\n" +
                "on programming_languages.prog_lang_id = dev_prog.prog_lang_id\n" +
                ");").getResultList();
        return list;
    }
}