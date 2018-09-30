package com.nabid.assignment.controller;

import com.nabid.assignment.entity.*;
import com.nabid.assignment.service.DevelopersService;
import com.nabid.assignment.service.InterviewsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
* Task no :03 is implemented here.
* JQuery and Bootstrap is used for UI
* DataTable is used for table.
* */
@Controller
public class InterviewsController {

    @Autowired
    DevelopersService developersService;
    @Autowired
    InterviewsService interviewsService;

    @RequestMapping("/interviews")
    public String getInterviewsPage(Model model){
        try{
            List<Developers> developersList = developersService.findAll();
            List<Interviews> interviewsList = interviewsService.findByIsDeleted();
            model.addAttribute("developersList", developersList);
            model.addAttribute("interviewsList", interviewsList);
            return "interviews";
        }
        catch (Exception e){
            return "error";
        }

    }

    @RequestMapping(value = "addInterview",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    String addInterview(@RequestBody InterviewFrontEndInfo info){
        Interviews interviews = new Interviews();
        interviews.setComment(info.getComment());
        interviews.setScore(Integer.parseInt(info.getScore()));
        interviews.setDevId(Long.valueOf(info.getDevId()));

        //get interview id
        long interviewId = interviewsService.save(interviews);
        JSONObject jo = new JSONObject();
        jo.put("score", info.getScore());
        jo.put("comment", info.getComment());
        jo.put("devId", info.getDevId());
        jo.put("interviewId", interviewId);
        return jo.toString();
    }


    @RequestMapping(value = "deleteInterview",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    String deleteInterview(@RequestBody DeleteInfo info){
        //delete interview here
        long id = Long.parseLong(info.getId());
        interviewsService.deleteInterview(id);
        JSONObject jo = new JSONObject();
        jo.put("message", "ok");
        return jo.toString();
    }




}