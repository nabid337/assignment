package com.nabid.assignment.service;

import com.nabid.assignment.entity.Interviews;
import com.nabid.assignment.repository.InterviewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewsServiceImpl implements InterviewsService{
    @Autowired
    InterviewsRepo interviewsRepo;


    @Override
    public long save(Interviews interviews) {
        Interviews interviews1 = new Interviews();
        interviews1 = interviewsRepo.save(interviews);
        interviewsRepo.flush();
        long id = interviews1.getInterviewId();
        return id;
    }

    @Override
    public void delete(Interviews interviews) {
        interviewsRepo.delete(interviews);
    }

    @Override
    public Interviews getDevelopersById(long id) {
            return null;
    }

    @Override
    public List<Interviews> findAll() {
            List<Interviews> interviewsList = interviewsRepo.findAll();
            return interviewsList;
    }

    @Override
    public void deleteInterview(long id) {
        Optional<Interviews> interviews = Optional.of(new Interviews());
        interviews = interviewsRepo.findById(id);
        interviews.get().setIsDeleted(1);
        interviewsRepo.save(interviews.get());
    }

    @Override
    public List<Interviews> findByIsDeleted() {
        List<Interviews> interviewsList = null;
        interviewsList = interviewsRepo.findByIsDeleted();
        return interviewsList;
    }


}