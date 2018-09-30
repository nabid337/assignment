package com.nabid.assignment.entity;


import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name= "dev_prog")
public class DevProg {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "dev_prog_id")
    private long devProgId;



    @Column(name = "dev_id")
    private long devId;

    @Column(name = "prog_lang_id")
    private long progLangId;

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public long getProgLangId() {
        return progLangId;
    }

    public void setProgLangId(long progLangId) {
        this.progLangId = progLangId;
    }

    public long getDevProgId() {
        return devProgId;
    }

    public void setDevProgId(long devProgId) {
        this.devProgId = devProgId;
    }
}
