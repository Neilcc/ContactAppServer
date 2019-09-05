package com.zcc.contactapp.server.redis;

import com.zcc.contactapp.server.dao.ContactInfo;
import com.zcc.contactapp.server.db.mybatis.ContactDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cc on 2019/9/5.
 */

@Slf4j
@Service
public class RedisCacheService {

    @Autowired
    private ContactDao contactDao;


    @Transactional
    @CachePut(value = "redisCache", key = "'redis_info_'+#result.id")
    public ContactInfo insertContact(ContactInfo info) {
        contactDao.insertContact(info);
        return info;
    }

    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_info_'+#id", condition = "#result != 'null'")
    public ContactInfo getContact(Long id) {
        return contactDao.getInfo(id);
    }

    @Transactional
    @CachePut(value = "redisCache",
            condition = "#result != 'null'", key = "'redis_info_'+#id")
    public ContactInfo updateContactInfo(Long id, String title) {
        ContactInfo contactInfo = contactDao.getInfo(id);
        if (contactInfo == null) {
            return null;
        }
        contactInfo.setTitle(title);
        contactDao.updateContact(contactInfo);
        return contactInfo;
    }

    @Transactional
    public List<ContactInfo> findContacts(String firstName, String title) {
        return contactDao.findContacts(firstName, title);
    }

    @Transactional
    @CacheEvict(value = "redisCache", key = "'redis_info_'+#id", beforeInvocation = false)
    public int deleteContact(Long id) {
        return contactDao.deleteContact(id);

    }


}
