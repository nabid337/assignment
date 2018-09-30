package com.nabid.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lang_seq")
    @SequenceGenerator(sequenceName = "languages_seq", allocationSize = 1, name = "lang_seq")
    @Column(name = "lang_id")
    private long langId;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Languages{" +
                "langId=" + langId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public long getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}