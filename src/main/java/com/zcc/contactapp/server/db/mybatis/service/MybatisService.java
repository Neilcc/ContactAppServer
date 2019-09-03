package com.zcc.contactapp.server.db.mybatis.service;

import com.zcc.contactapp.server.dao.ContactInfo;

/**
 * Created by cc on 2019/9/3.
 */

public interface MybatisService {
    public ContactInfo getInfo(Long id);
}
