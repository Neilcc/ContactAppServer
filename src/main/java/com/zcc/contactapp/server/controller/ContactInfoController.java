package com.zcc.contactapp.server.controller;

import com.zcc.contactapp.server.common.CommonResult;
import com.zcc.contactapp.server.service.ContactInfoService;
import com.zcc.contactapp.server.vo.InfoRetVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 2019/4/2.
 */
@Slf4j
@RestController
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @Autowired
    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @RequestMapping(value = "/contacts/getinfo", method = RequestMethod.GET)
    public CommonResult<InfoRetVO> getContacts(
            @RequestParam(value = "token", required = false, defaultValue = "") String token) {
        return new CommonResult<>(contactInfoService.getInfoList(token));
    }
}
