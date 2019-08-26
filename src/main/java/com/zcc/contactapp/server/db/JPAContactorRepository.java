package com.zcc.contactapp.server.db;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cc on 2019/8/26.
 */
public interface JPAContactorRepository extends JpaRepository<ContactInfo, Long> {
}
