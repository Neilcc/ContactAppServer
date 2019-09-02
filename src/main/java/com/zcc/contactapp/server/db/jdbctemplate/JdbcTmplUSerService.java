package com.zcc.contactapp.server.db.jdbctemplate;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cc on 2019/9/2.
 */
public interface JdbcTmplUSerService {
    public ContactInfo getContact(int id);

    public List<ContactInfo> findContact(String firstName, String note);

    public int insertUser(ContactInfo contactInfo);

    public int updateUser(ContactInfo contactInfo);

    public int deleteUser(int id);

}
