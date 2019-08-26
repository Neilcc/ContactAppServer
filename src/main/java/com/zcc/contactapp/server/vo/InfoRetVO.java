package com.zcc.contactapp.server.vo;

import com.zcc.contactapp.server.dao.ContactInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by cc on 2019/4/2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoRetVO {

    List<ContactInfo> contactInfoList;

    String continueToken;
}
