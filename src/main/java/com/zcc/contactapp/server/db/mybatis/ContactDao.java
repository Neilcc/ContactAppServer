package com.zcc.contactapp.server.db.mybatis;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cc on 2019/9/3.
 */
@Repository
public interface ContactDao {

    public ContactInfo getInfo(Long id);

    public int insertContact(ContactInfo info);

    public int updateContact(ContactInfo info);

    // @param 是在mapper 里面 按照这个key 从map 中取值， 看起来如果传obj 则是按照成员的def 默认为key
    List<ContactInfo> findContacts(@Param("first_name") String firstName,
                                   @Param("title") String title);

    public int deleteContact(Long id);
}
