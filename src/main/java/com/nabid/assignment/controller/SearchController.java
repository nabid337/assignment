package com.nabid.assignment.controller;

import com.nabid.assignment.entity.*;
import com.nabid.assignment.service.DevelopersService;
import com.nabid.assignment.service.LanguagesService;
import com.nabid.assignment.service.ProgrammingLanguagesService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


/*
 * Task-01 is implemented here.
 * Dummy data is uploaded in DBSeeder.
 * */
@Controller
public class SearchController {
    @Autowired
    DevelopersService developersService;
    @Autowired
    LanguagesService languagesService;
    @Autowired
    ProgrammingLanguagesService programmingLanguagesService;

    @RequestMapping("/search")
    String search(Model model){



        List<Developers> developersList = developersService.findAll();
        List<Languages> languagesList = languagesService.findAll();
        List<ProgrammingLanguages> programmingLanguagesList = programmingLanguagesService.findAll();

        model.addAttribute("developersList", developersList);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("programmingLanguagesList", programmingLanguagesList);
        return "search";
    }

    @RequestMapping(value = "displayDevelopers",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody

    String displayDevelopers(@RequestBody SearchPeram info){
        boolean check = false;
        String[] langCode = info.getLangCode().split(",");
        String[] progLangId= info.getProgLangId().split(",");
        List<Object[]> list = null;
        if (langCode[0].equals("") && !progLangId[0].equals("") && progLangId.length==1){
            long id = Long.valueOf(progLangId[0]);
            list = developersService.getDevOneProgLang(id);
        }

        else if (!langCode[0].equals("") && !progLangId[0].equals("") && langCode.length==1 && progLangId.length==1){
            long id = Long.valueOf(progLangId[0]);
            String code = langCode[0];
            list = developersService.getDevOneProgOneLang(id, code);
        }
        else if(!langCode[0].equals("") && progLangId.length>1 && langCode.length==1){
            long id1 = Long.valueOf(progLangId[0]);
            long id2 = Long.valueOf(progLangId[1]);
            String code = langCode[0];
            list = developersService.getDevTwoProgOneLang(id1,id2,code);
            check = true;
        }
        else{
            JSONObject jo = new JSONObject();
            jo.put("tableMarkup", "");
            return jo.toString();
        }

      /*  List<Object[]> developerDetailList =
                developersService.getDevDetailsSearchWise(langCode,progLangId );*/

        String table = "<table style=\"width:70%\">\n" +
                "  <tr>\n" +
                "    <th>Developer ID</th>\n" +
                "    <th>Email</th> \n" +
                "    <th>Programming language</th>\n" +
                "    <th>Language</th>\n" +
                "  </tr>";
        String row = generateRow(list,check);
        table+=row;
        table+="</table>";

        JSONObject jo = new JSONObject();
        jo.put("tableMarkup", table);
        return jo.toString();
    }

    public String generateRow(List<Object[]> list, boolean check){
        String tr = "";
        if (!check){
            for (int i=0; i<list.size(); i++){
                Object[] row = (Object[]) list.get(i);
                tr += " <tr>" +
                        "    <td>" + row[0] +"</td>" +
                        "    <td>" + row[1]+"</td>" +
                        "    <td>" + row[2] +"</td>" +
                        "    <td>" +  row[3] +"</td>" +
                        "  </tr>";
            }
        }
        else{
            if (list.size()==1){
                tr += " <tr>" +
                        "    <td>" + "" +"</td>" +
                        "    <td>" + ""+"</td>" +
                        "    <td>" + "" +"</td>" +
                        "    <td>" +  "" +"</td>" +
                        "  </tr>";
            }
            else{
                for (int i=0; i<list.size(); i++){
                    Object[] row = (Object[]) list.get(i);
                        try{
                            Object[] rowCheck = (Object[]) list.get(i+1);
                            if (row[1].equals(rowCheck[1])){
                                tr += " <tr>" +
                                        "    <td>" + row[0] +"</td>" +
                                        "    <td>" + row[1]+"</td>" +
                                        "    <td>" + row[2] +"</td>" +
                                        "    <td>" +  row[3] +"</td>" +
                                        "  </tr>";

                                tr += " <tr>" +
                                        "    <td>" + rowCheck[0] +"</td>" +
                                        "    <td>" + rowCheck[1]+"</td>" +
                                        "    <td>" + rowCheck[2] +"</td>" +
                                        "    <td>" +  rowCheck[3] +"</td>" +
                                        "  </tr>";
                            }
                        }catch (Exception e){
                            tr += " <tr>" +
                                    "    <td>" + "" +"</td>" +
                                    "    <td>" + ""+"</td>" +
                                    "    <td>" + "" +"</td>" +
                                    "    <td>" +  "" +"</td>" +
                                    "  </tr>";
                        }





                }
            }

        }


        return tr;
    }
    /*
    *  Extracted “programming_languages” which is not used in any developers.
    * */
    @GetMapping(value = "/getNotUsedProgLang", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Object[]> notUsedProgLang(){
        try{
            List<Object[]> list = programmingLanguagesService.getNotUsedProgLang();
            return new ResponseEntity(list, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
