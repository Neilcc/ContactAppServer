package com.zcc.contactapp.server.controller;

import com.zcc.contactapp.server.dao.ContactInfo;
import com.zcc.contactapp.server.db.jdbctemplate.JdbcTmplUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 2019/9/2.
 */
@RestController
public class JdbcTemplateController {
    @Autowired
    JdbcTmplUSerService jdbcTmplUSerService;

    @RequestMapping(value = "/jdbc/defaultOne", method = RequestMethod.GET)
    public ContactInfo getDefault() {
        return jdbcTmplUSerService.getContact(1);
    }
}
