package com.zcc.contactapp.server.mapper;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cc on 2019/4/2.
 */

@Mapper
public interface ContactInfoMapper {

    @Select("SELECT * FROM contact_info_db WHERE id >= #{start} AND id < #{end};")
    List<ContactInfo> getContactInfos(int start, int end);

}
