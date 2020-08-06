package com.example.lecture.repository;

import com.example.lecture.entity.Members;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class MembersRepository {
    static final Logger log = LoggerFactory.getLogger(MembersRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void signup(Members members) throws Exception {
        log.info("Repository signup()");

        String query = "insert into members( id, pw, name, dob, contact) value ( ?, ?, ?, ?, ? )";
        jdbcTemplate.update(query, members.getId(), members.getPw(), members.getName(), members.getDob(), members.getContact());

    }

    public boolean login(Members members) throws Exception {
        log.info("Repository login()");

        String query = "select id, pw from members where id=? and pw=?";
        List<Members> results =  jdbcTemplate.query(query, new RowMapper<Members>(){
                    @Override
                    public Members mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Members members = new Members();

                        members.setId(rs.getString("id"));
                        members.setPw(rs.getString("pw"));

                        return members;
                    }
                }
        , members.getId(), members.getPw());
        return results.isEmpty() ? true : false;
    }

    public boolean idcheck(Members members) throws Exception {
        log.info("Repository idcheck()");

        String query = "select id from members where id=? ";
        List<Members> results =  jdbcTemplate.query(query, new RowMapper<Members>(){
                    @Override
                    public Members mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Members members = new Members();

                        members.setId(rs.getString("id"));


                        return members;
                    }
                }
                , members.getId());
        return results.isEmpty() ? true : false;
    }
}
