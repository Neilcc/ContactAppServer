package com.zcc.contactapp.server.db;

import com.zcc.contactapp.server.dao.Contactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cc on 2019/8/26.
 */
@Service
public class JDBCImpl implements IJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    @Override
    public Contactor getContactor(Long id) {
        RowMapper<Contactor> mapper = (rs, rowNum) -> {
            return new Contactor();
        };
        return null;
    }
}
