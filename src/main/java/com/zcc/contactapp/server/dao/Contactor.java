package com.zcc.contactapp.server.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cc on 2019/8/26.
 */
public class Contactor {
    private Long id = null;
    private String first_name;
    private String last_name;
    private String avatar_filename;
    private String title;
    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar_filename() {
        return avatar_filename;
    }

    public void setAvatar_filename(String avatar_filename) {
        this.avatar_filename = avatar_filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
