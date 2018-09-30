package com.nabid.assignment.entity;


import javax.persistence.*;

@Entity
@Table(name = "interviews")
public class Interviews {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "interview_id")
    private long interviewId;

    @Column(name = "score ")
    private int score;

    @Column(name = "comment")
    private String comment;

    @Column(name = "dev_id ")
    private long devId;

    @Column(name = "is_deleted")
    private int isDeleted;

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(long interviewId) {
        this.interviewId = interviewId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }
}