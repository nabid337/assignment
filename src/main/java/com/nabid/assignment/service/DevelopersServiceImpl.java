package com.nabid.assignment.service;

import com.nabid.assignment.entity.DeveloperDetail;
import com.nabid.assignment.entity.Developers;
import com.nabid.assignment.repository.DevelopersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DevelopersServiceImpl implements DevelopersService {

    @Autowired
    DevelopersRepo developersRepo;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public long save(Developers developers) {
        Developers developers1 = new Developers();
        developers1 = developersRepo.save(developers);
        developersRepo.flush();
        long id = developers1.getDevId();
        return id;
    }

    @Override
    public void deleteDeveloper(long id) {
     /*   int res = entityManager.createNativeQuery("UPDATE developers SET is_deleted = 1" +
                " WHERE dev_id="+ id + ";").executeUpdate();*/
      developersRepo.deleteById(id);

    }

    @Override
    public Optional<Developers> getDevelopersById(long id) {
         return developersRepo.findById(id);

    }


    @Override
    public List<Developers> findAll() {
       /* List<Developers> developers =
                entityManager.createNativeQuery("select * from developers where is_deleted =0;").getResultList();
        return developers;*/
        return developersRepo.findAll();
    }

    @Override
    public List<Object[]> getDevDetails(long id) {

        List<Object[]> developerDetailList = entityManager.createNativeQuery("select distinct developers.dev_id as devId,\n" +
                "                 developers.email as email,\n" +
                "                programming_languages.name as programming_language,\n" +
                "                languages.name as langName\n" +
                "                 from developers\n" +
                "                left join dev_prog\n" +
                "                on dev_prog.dev_id = developers.dev_id\n" +
                "                left join programming_languages\n" +
                "                on programming_languages.prog_lang_id = dev_prog.prog_lang_id\n" +
                "                left join dev_lang\n" +
                "                on dev_lang.dev_id = developers.dev_id\n" +
                "                left join languages\n" +
                "                on languages.lang_id = dev_lang.lang_id\n" +
                "                where developers.dev_id="+ id +"\n" +
                "                ;").getResultList();

       // entityManager.createNativeQuery("UPDATE person p SET firstname = firstname || '-changed'").executeUpdate();

        return developerDetailList;

        //assertEquals(Long.valueOf(2), commentCount);
    }

    @Override
    public Optional<Developers> findById(long id) {
        return developersRepo.findById(id);
    }

    @Override
    public List<Object[]> getDevOneProgLang(long progLangId) {
        List<Object[]> list = null;
        list = entityManager.createNativeQuery("select distinct developers.dev_id as devId,\n" +
                "developers.email as email,\n" +
                "programming_languages.name as programming_language,\n" +
                "languages.name as langName\n" +
                "from developers\n" +
                "left join dev_prog\n" +
                "on dev_prog.dev_id = developers.dev_id\n" +
                "left join programming_languages\n" +
                "on programming_languages.prog_lang_id = dev_prog.prog_lang_id\n" +
                "left join dev_lang\n" +
                "on dev_lang.dev_id = developers.dev_id\n" +
                "left join languages\n" +
                "on languages.lang_id = dev_lang.lang_id                 \n" +
                "where  programming_languages.prog_lang_id =" +  progLangId + ";").getResultList();

        return list;
    }

    @Override
    public List<Object[]> getDevOneProgOneLang(long progLangId, String code) {
        List<Object[]> list = null;
        list = entityManager.createNativeQuery("select distinct developers.dev_id as devId,\n" +
                "developers.email as email,\n" +
                "programming_languages.name as programming_language,\n" +
                "languages.name as langName\n" +
                "from developers\n" +
                "left join dev_prog\n" +
                "on dev_prog.dev_id = developers.dev_id\n" +
                "left join programming_languages\n" +
                "on programming_languages.prog_lang_id = dev_prog.prog_lang_id\n" +
                "left join dev_lang\n" +
                "on dev_lang.dev_id = developers.dev_id\n" +
                "left join languages\n" +
                "on languages.lang_id = dev_lang.lang_id                 \n" +
                "where  programming_languages.prog_lang_id =" + progLangId + "\n" +
                "and languages.code ='" + code + "'" + ";").getResultList();

        return list;
    }

    @Override
    public List<Object[]> getDevTwoProgOneLang(long progLangId1, long progLangId2, String code) {
        List<Object[]> list = null;
        list  = entityManager.createNativeQuery("select distinct developers.dev_id as devId,\n" +
                "developers.email as email,\n" +
                "programming_languages.name as programming_language,\n" +
                "languages.name as langName\n" +
                "from developers\n" +
                "left join dev_prog\n" +
                "on dev_prog.dev_id = developers.dev_id\n" +
                "left join programming_languages\n" +
                "on programming_languages.prog_lang_id = dev_prog.prog_lang_id\n" +
                "left join dev_lang\n" +
                "on dev_lang.dev_id = developers.dev_id\n" +
                "left join languages\n" +
                "on languages.lang_id = dev_lang.lang_id \n" +
                "where  programming_languages.prog_lang_id =" + progLangId1 + "\n" +
                "and languages.code = '" + code + "'" + "\n" +
                "union\n" +
                "select distinct developers.dev_id as devId,\n" +
                "developers.email as email,\n" +
                "programming_languages.name as programming_language,\n" +
                "languages.name as langName\n" +
                "from developers\n" +
                "left join dev_prog\n" +
                " on dev_prog.dev_id = developers.dev_id\n" +
                "left join programming_languages\n" +
                "on programming_languages.prog_lang_id = dev_prog.prog_lang_id\n" +
                "left join dev_lang\n" +
                "on dev_lang.dev_id = developers.dev_id\n" +
                "left join languages\n" +
                "on languages.lang_id = dev_lang.lang_id \n" +
                "where  programming_languages.prog_lang_id =" + progLangId2 + "\n" +
                "and languages.code = '" + code + "'" + "\n" +
                ";").getResultList();
        return list;
    }

    @Override
    public List<Object[]> getDevTwoProg(long progLangId1, long progLangId2) {
        List<Object[]> list = null;
        list = entityManager.createNativeQuery("").getResultList();

        return list;
    }


}
