package com.nabid.assignment.seeder;

import com.nabid.assignment.entity.*;
import com.nabid.assignment.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/*

* Task :02 is implemented here
* Created a seeder mechanism.
 Created dummy “developer”’s records (10 records) using a seeder that are
associated with “programming_languages” and “languages” with another seeder
*
* */
@Component
public class DatabaseSeeder {

    @Autowired
    DevelopersService developersService;
    @Autowired
    ProgrammingLanguagesService programmingLanguagesService;
    @Autowired
    LanguagesService languagesService;
    @Autowired
    DevProgService devProgService;
    @Autowired
    DevLangService devLangService;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {

        seedDevelopers();
        seedProgLang();
        seedLang();
        seedDevProg();
        seedDevLang();


    }

    protected void seedDevelopers(){
        try{
            List<Developers> developersList = developersService.findAll();
            if (developersList.size()>0){
                System.out.println("Developers already seeded");
            }
            else{

                for (int i=0; i<10; i++){
                    Developers developersNew = new Developers();
                    String email = getSaltString() + "@example.com";
                    developersNew.setEmail(email);
                    long devId = developersService.save(developersNew);
                }
                System.out.println("event fired");
            }
        }
        catch (Exception e){
            System.out.println("Something Went wrong!");
        }

    }

    protected void seedProgLang(){
        try{
            String [] progLang = {"Java", "Ruby", "Python", "C#", "C", "C++", "JavaScript", "TypeScript", "PHP", "Swift"};

            List<ProgrammingLanguages> programmingLanguagesList = programmingLanguagesService.findAll();
            if (programmingLanguagesList.size()>0){
                System.out.println("Programming Languages already seeded");
            }
            else{
                for (int i=0; i<progLang.length; i++){
                    ProgrammingLanguages programmingLanguages = new ProgrammingLanguages();
                    programmingLanguages.setName(progLang[i]);
                    programmingLanguagesService.save(programmingLanguages);
                }
            }
        }
        catch (Exception e){
            System.out.println("Something Went wrong!");
        }


    }

    protected void seedLang(){

        try{
            HashMap<String, String> hmap = new HashMap<String, String>();
            hmap.put("jp", "Japanese");
            hmap.put("en", "English");
            hmap.put("bd", "Bangla");
            hmap.put("spn", "Spanish");
            hmap.put("fn", "French");
            hmap.put("rs", "Russian");
            hmap.put("hn", "Hindi");
            hmap.put("ab", "Arabic");

            List<Languages> languagesList = languagesService.findAll();
            if (languagesList.size()>0){
                System.out.println("Languages already seeded");
            }
            else{
                Set set = hmap.entrySet();
                Iterator iterator = set.iterator();
                while(iterator.hasNext()) {
                    Languages languages = new Languages();
                    Map.Entry mentry = (Map.Entry)iterator.next();
                    languages.setCode((String) mentry.getKey());
                    languages.setName((String) mentry.getValue());
                    languagesService.save(languages);
                }
            }
        }
        catch (Exception e){
            System.out.println("Something Went wrong!");
        }



    }
    //Developers Programming Language join table seeded here
    protected void seedDevProg(){
        try{
            List<Developers> developersList = developersService.findAll();
            List<ProgrammingLanguages> programmingLanguagesList = programmingLanguagesService.findAll();

            if (devProgService.findAll().size()>0){
                System.out.println("Developers Programming language join table already seeded");
            }
            else{
                List<Long> devId = new ArrayList<>();
                for (int i=0; i<developersList.size(); i++){
                    devId.add(developersList.get(i).getDevId());
                }

                List<Long> progLangId = new ArrayList<>();
                for (int i=0; i<programmingLanguagesList.size(); i++){
                    progLangId.add(programmingLanguagesList.get(i).getProgLangId());
                }


                for (int i=0; i<devId.size(); i++){
                    Random rand = new Random();
                    int n1 = rand.nextInt(progLangId.size()) + 0;
                    int n2 = rand.nextInt(progLangId.size()) + 0;
                    if (n2==n1) n2 = rand.nextInt(progLangId.size()) + 0;

                    DevProg devProg1 = new DevProg();
                    devProg1.setDevId(devId.get(i));
                    devProg1.setProgLangId(progLangId.get(n1));
                    devProgService.save(devProg1);

                    DevProg devProg2 = new DevProg();
                    devProg2.setDevId(devId.get(i));
                    devProg2.setProgLangId(progLangId.get(n2));
                    devProgService.save(devProg2);


                }
            }
        }
        catch (Exception e){
            System.out.println("Something Went wrong!");
        }


    }

    //Developers  Language join table seeded here
    protected void seedDevLang(){
        try{
            List<Developers> developersList = developersService.findAll();
            List<Languages> languagesList = languagesService.findAll();

            if (devLangService.findAll().size()>0){
                System.out.println("Developers Languages join table already seeded");
            }
            else{
                List<Long> devId = new ArrayList<>();
                for (int i=0; i<developersList.size(); i++){
                    devId.add(developersList.get(i).getDevId());
                }

                List<Long> langId = new ArrayList<>();
                for (int i=0; i<languagesList.size(); i++){
                    langId.add(languagesList.get(i).getLangId());
                }


                for (int i=0; i<devId.size(); i++){
                    Random rand = new Random();
                    int n1 = rand.nextInt(langId.size()) + 0;
                    int n2 = rand.nextInt(langId.size()) + 0;
                    if (n2==n1) n2 = rand.nextInt(langId.size()) + 0;

                    DevLang devLang1 = new DevLang();
                    devLang1.setDevId(devId.get(i));
                    devLang1.setLangId(devId.get(i));
                    devLangService.save(devLang1);

                    DevLang devLang2 = new DevLang();
                    devLang2.setDevId(devId.get(i));
                    devLang2.setLangId(devId.get(i));
                    devLangService.save(devLang2);


                }
            }
        }
        catch (Exception e){
            System.out.println("Something Went wrong!");
        }


    }

    //For generatin random email name
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz.-_";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
