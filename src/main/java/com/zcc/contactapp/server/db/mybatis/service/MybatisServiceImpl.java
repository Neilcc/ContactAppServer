package com.zcc.contactapp.server.db.mybatis.service;

import com.zcc.contactapp.server.dao.ContactInfo;
import com.zcc.contactapp.server.db.mybatis.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 2019/9/3.
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactInfo getInfo(Long id) {
        return contactDao.getInfo(id);
    }
}
