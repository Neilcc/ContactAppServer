package com.zcc.contactapp.server.db.mybatis;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by cc on 2019/9/3.
 */
@Repository
public interface ContactDao {

    public ContactInfo getInfo(Long id);
}
