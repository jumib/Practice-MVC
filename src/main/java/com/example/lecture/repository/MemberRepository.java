package com.example.lecture.repository;

import com.example.lecture.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    static final Logger log = LoggerFactory.getLogger(MemberRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        log.info("Repository create()");
        String query = "insert into member(" +
                "userid, userpw, username, userbirth) values(?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getUserId(), member.getUserPw(), member.getUserName(), member.getUserBirth());
    }
}
