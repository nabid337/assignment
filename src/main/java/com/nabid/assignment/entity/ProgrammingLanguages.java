package com.nabid.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "programming_languages")
public class ProgrammingLanguages {

    @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prog_seq")
   // @SequenceGenerator(sequenceName = "prog_lang_seq", allocationSize = 1, name = "prog_seq")
    @Column(name = "prog_lang_id")
    private long progLangId;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "ProgrammingLanguages{" +
                "progLangId=" + progLangId +
                ", name='" + name + '\'' +
                '}';
    }

    public long getProgLangId() {
        return progLangId;
    }

    public void setProgLangId(long progLangId) {
        this.progLangId = progLangId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
