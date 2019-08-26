package com.zcc.contactapp.server.controller;

import com.zcc.contactapp.server.dao.ContactInfo;
import com.zcc.contactapp.server.db.JPAContactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2019/8/26.
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private JPAContactorRepository jpaContactorRepository = null;

    @RequestMapping("/getContactor")
    @ResponseBody
    public ContactInfo getContactor(Long id) {
        ContactInfo contactInfo = jpaContactorRepository.findById(id).get();
        return contactInfo;
    }
}
