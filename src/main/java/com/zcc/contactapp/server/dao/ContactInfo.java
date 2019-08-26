package com.zcc.contactapp.server.dao;

import lombok.Data;

/**
 * Created by cc on 2019/4/2.
 */
@Data
public class ContactInfo {

    private Integer id;

    private String name;

    private String avatarUrl;

    private String title;

    private String desc;
}
