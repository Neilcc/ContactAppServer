package com.zcc.contactapp.server.service;

import com.zcc.contactapp.server.common.Utils;
import com.zcc.contactapp.server.config.GetInfoConfigs;
import com.zcc.contactapp.server.dao.ContactInfo;
import com.zcc.contactapp.server.exception.IllegalParamsException;
import com.zcc.contactapp.server.mapper.ContactInfoMapper;
import com.zcc.contactapp.server.vo.InfoRetVO;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cc on 2019/4/2.
 */

@Slf4j
@Service
public class ContactInfoService {

//    private final ContactInfoMapper contactInfoMapper;
    private final GetInfoConfigs getInfoConfigs;

    @Autowired
    public ContactInfoService(
//            ContactInfoMapper contactInfoMapper,
                              GetInfoConfigs getInfoConfigs) {
//        this.contactInfoMapper = contactInfoMapper;
        this.getInfoConfigs = getInfoConfigs;
    }

    @Cacheable(value = "infoList", sync = true)
    public InfoRetVO getInfoList(String token) {
        String nextToken;
        int start = 0;
        int end = getInfoConfigs.getPageSize();
        if (!token.isEmpty()) {
            try {
                Pair<Integer, Integer> target = Utils.decode(token);
                start = target.getKey();
                end = target.getValue();
            } catch (IllegalParamsException e) {
                e.printStackTrace();
                // ignore
            }
        }
        nextToken = Utils.encode(start + getInfoConfigs.getPageSize(),
                end + getInfoConfigs.getPageSize());
//        return new InfoRetVO(contactInfoMapper.getContactInfos(start, end), nextToken);
        return null;
    }

}
