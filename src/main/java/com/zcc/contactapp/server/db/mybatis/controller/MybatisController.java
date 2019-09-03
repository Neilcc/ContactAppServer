package com.zcc.contactapp.server.db.mybatis.controller;

import com.zcc.contactapp.server.dao.ContactInfo;
import com.zcc.contactapp.server.db.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 2019/9/3.
 */

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    MybatisService mybatisService;

    @RequestMapping("/getinfo")
    public ContactInfo getInfo(Long id) {
        return mybatisService.getInfo(id);
    }
}
