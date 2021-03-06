package com.nabid.assignment.controller;

import com.nabid.assignment.entity.*;
import com.nabid.assignment.service.DevelopersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


/*
* Task No:04 is implemented here.
* GET, PUT, POST & DELETE requests are handled here.
* Associate information's show in GET request.
* Any kind of problem will response in INTERNAL SERVER ERROR.
* */
@RestController
public class ApiController {

    @Autowired
    DevelopersService developersService;


    @GetMapping(value = "/getDeveloper/{id}" , produces = "application/json")
    @ResponseBody
    public ResponseEntity<DeveloperDetail> getDeveloper(@PathVariable long id){



        try{
            List<Object[]> developerDetailList = developersService.getDevDetails(id);
            String[] arrayLang = new String[developerDetailList.size()];
            String[] arrayProg = new String[developerDetailList.size()];
            int x=0,y=0;

            String progLang ="", langName = "";
            try{
                for (int i=0; i<developerDetailList.size(); i++){
                    Object[] row = (Object[]) developerDetailList.get(i);
                    //Object[] rowCheck = (Object[]) developerDetailList.get(i+1);
                  //  if(!row[2].equals(rowCheck[2]))
                        arrayProg[y++] = row[2]+"";
                   // if(!row[3].equals(rowCheck[3]))
                        arrayLang[x++] = row[3]+"" ;
                }
            }
            catch (Exception ex){

            }
            arrayLang = new HashSet<String>(Arrays.asList(arrayLang)).toArray(new String[0]);
            arrayProg = new HashSet<String>(Arrays.asList(arrayProg)).toArray(new String[0]);

            Object[] row = (Object[]) developerDetailList.get(0);
            String s = new String(row[0].toString());
            long devId = Long.valueOf(s);
            DeveloperDetail developerDetail = new DeveloperDetail();
            developerDetail.setDev_id(devId);
            developerDetail.setEmail((String) row[1]);
            developerDetail.setLangName(Arrays.toString(arrayLang));
            developerDetail.setProgramming_language(Arrays.toString(arrayProg));

            return new ResponseEntity(developerDetail, HttpStatus.OK);
        }
        catch (Exception e){
            DeveloperDetail developerDetail = new DeveloperDetail();
            developerDetail.setDev_id(id);
            return new ResponseEntity(developerDetail, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping(value = "/updateDeveloper")
    @ResponseBody
    public ResponseEntity<String> updateDeveloper(@RequestBody DevUpdateBody devUpdateBody){
        try{
            Optional<Developers> developers = developersService.findById(devUpdateBody.getId());
            if (!developers.isPresent())  return new ResponseEntity<String>("No such developer found by this id: " +
                    devUpdateBody.getId(), HttpStatus.OK);

            Developers devUpdate = new Developers();
            devUpdate.setDevId(devUpdateBody.getId());
            devUpdate.setEmail(devUpdateBody.getNewEmail());
            long id = developersService.save(devUpdate);
            String response = "Developer id: " + devUpdateBody.getId() + " new email: " + devUpdateBody.getNewEmail();
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Couldn't update resource", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "/createDeveloper" , produces = "application/json")
    @ResponseBody
    public ResponseEntity<Developers> createDeveloper(@RequestBody DeveloperReqBody developerReqBody){
        try{
            Developers developers = new Developers();
            developers.setEmail(developerReqBody.getEmail());
            long devId = developersService.save(developers);

            Developers developersResponse = new Developers();
            developersResponse.setEmail(developers.getEmail());
            developersResponse.setDevId(devId);

            return new ResponseEntity<Developers>(developersResponse, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Developers>(new Developers(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value = "/deleteDeveloper/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteDeveloper(@PathVariable long id){
        try{
            developersService.deleteDeveloper(id);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Couldn't delete the resource", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
