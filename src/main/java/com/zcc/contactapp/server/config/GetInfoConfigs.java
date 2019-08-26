package com.zcc.contactapp.server.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by cc on 2019/4/2.
 */
@Data
@Component
public class GetInfoConfigs {

    @Value("${listConfig.pageSize}")
    private int pageSize;

}
