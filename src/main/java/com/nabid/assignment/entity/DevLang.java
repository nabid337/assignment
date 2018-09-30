package com.nabid.assignment.entity;


import javax.persistence.*;

@Entity
@Table(name= "dev_lang")
public class DevLang {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "dev_lang_id")
    private long devLangId;

    @Column(name = "dev_id")
    private long devId;

    @Column(name = "lang_id")
    private long langId;

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public long getLangId() {
        return langId;
    }

    public void setLangId(long langId) {
        this.langId = langId;
    }
}
