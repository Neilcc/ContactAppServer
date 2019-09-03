package com.zcc.contactapp.server.db.hibernate;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cc on 2019/9/3.
 */
public interface JpaContactorRepository extends JpaRepository<ContactInfo, Long> {
}
