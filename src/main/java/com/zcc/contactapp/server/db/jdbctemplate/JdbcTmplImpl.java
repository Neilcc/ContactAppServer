package com.zcc.contactapp.server.db.jdbctemplate;

import com.zcc.contactapp.server.dao.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cc on 2019/9/2.
 */
@Service
public class JdbcTmplImpl implements JdbcTmplUSerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ContactInfo> getUserMapper() {
        RowMapper<ContactInfo> infoRowMapper = (rs, rowNum) -> {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setId(rs.getLong("id"));
            contactInfo.setFirstName(rs.getString("first_name"));
            contactInfo.setLastName(rs.getString("last_name"));
            contactInfo.setDesc(rs.getString("introduction"));
            contactInfo.setAvatarUrl(rs.getString("avatar_filename"));
            return contactInfo;
        };
        return infoRowMapper;
    }

    @Override
    public ContactInfo getContact(int id) {
        String sql = "select id, first_name ,last_name, introduction, avatar_filename from contacts where id = ?";
        Object[] params = new Object[]{id};
        ContactInfo contactInfo = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return contactInfo;
    }

    @Override
    public List<ContactInfo> findContact(String firstName, String note) {
        String sql = "select id, first_name ,last_name, introduction, avatar_filename from contacts where first_name like contat('%'?,'%')";
        Object[] params = new Object[]{firstName};
        return jdbcTemplate.query(sql, params, getUserMapper());
    }

    @Override
    public int insertUser(ContactInfo contactInfo) {
        String sql = "insert into contacts (first_name, last_name, introduction, avatar_filename) values" +
                "(?,?,?,?)";
        return jdbcTemplate.update(sql, contactInfo.getFirstName(), contactInfo.getLastName(), contactInfo.getDesc(), contactInfo.getAvatarUrl());
    }

    @Override
    public int updateUser(ContactInfo contactInfo) {
        String sql = "update contacts set first_name=?, last_name=?, introduction=?, avatar_file_name=? WHERE id = ?";
        return jdbcTemplate.update(sql, contactInfo.getFirstName(), contactInfo.getLastName(), contactInfo.getDesc(), contactInfo.getAvatarUrl(), contactInfo.getId());

    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from contacts where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
