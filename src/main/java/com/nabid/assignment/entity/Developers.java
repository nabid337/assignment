package com.nabid.assignment.entity;


import javax.persistence.*;

@Entity
@Table(name= "developers")

public class Developers {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_seq")
   // @SequenceGenerator(sequenceName = "developers_seq", allocationSize = 1, name = "dev_seq")
    @Column(name = "dev_id")
    private long devId;
    @Column(name = "email")
    private String email;





    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "devId=" + devId +
                ", email='" + email + '\'' +
                '}';
    }


}
