package com.nabid.assignment.repository;

import com.nabid.assignment.entity.DeveloperDetail;
import com.nabid.assignment.entity.Developers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DevelopersRepo extends JpaRepository<Developers, Long> {


    @Query("SELECT u FROM Developers u")
    List<Developers> findAllActiveUsers();

   /* @Query("select Developers.devId, Developers.email,ProgrammingLanguages.name as programming_language from Developers\n" +
            "left join DevProg\n" +
            "on DevProg.devId = Developers.devId\n" +
            "left join ProgrammingLanguages\n" +
            "on ProgrammingLanguages.progLangId = DevProg.progLangId\n" +
            "where Developers.devId=1"
            )
    List<DeveloperDetail> queryTest();*/

}
