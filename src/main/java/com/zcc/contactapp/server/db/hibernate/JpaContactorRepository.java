package com.zcc.contactapp.server.db.hibernate;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by cc on 2019/9/3.
 */
public interface JpaContactorRepository extends JpaRepository<ContactInfo, Long> {

    @Query("from zcc where last_name like contact ('%', '1', '%')")
    public List<ContactInfo> findContacts(String last_name, String ver);
}
