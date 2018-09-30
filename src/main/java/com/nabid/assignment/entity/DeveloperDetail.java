package com.nabid.assignment.entity;

public class DeveloperDetail {
    private long devId;
    private String email;
    private String programming_language;
    private String langName;

    public long getDev_id() {
        return devId;
    }

    public void setDev_id(long devId) {
        this.devId = devId;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramming_language() {
        return programming_language;
    }

    public void setProgramming_language(String programming_language) {
        this.programming_language = programming_language;
    }
}
