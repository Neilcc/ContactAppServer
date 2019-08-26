package com.zcc.contactapp.server.db;

import com.zcc.contactapp.server.dao.Contactor;

/**
 * Created by cc on 2019/8/26.
 */
public interface IJDBC {

    public Contactor getContactor(Long id);
}
