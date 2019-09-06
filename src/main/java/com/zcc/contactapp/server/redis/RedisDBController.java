package com.zcc.contactapp.server.redis;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cc on 2019/9/6.
 */
@RestController
@RequestMapping("/redis")
public class RedisDBController {

    @Autowired
    private RedisCacheService redisCacheService;

    @RequestMapping("/getInfo")
    public ContactInfo getInfo(Long id) {
        return redisCacheService.getContact(id);
    }

    @RequestMapping("/insert")
    public ContactInfo insert(String fistName, String lastName, String title) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setFirstName(fistName);
        contactInfo.setLastName(lastName);
        contactInfo.setTitle(title);
        return redisCacheService.insertContact(contactInfo);
    }

    @RequestMapping("/update")
    public ContactInfo updateContact(Long id, String title) {
        return redisCacheService.updateContactInfo(id, title);
    }

    @RequestMapping("/find")
    public List<ContactInfo> findContacts(String firstName, String title) {
        return redisCacheService.findContacts(firstName, title);
    }

    @RequestMapping("/delectInfo")
    public int deleteContact(Long id){
       return redisCacheService.deleteContact(id);
    }

}
