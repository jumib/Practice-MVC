package com.example.lecture.repository;

import com.example.lecture.entity.Board;
import com.example.lecture.entity.ItemMania;
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
public class ItemManiaRepository {
    static final Logger log = LoggerFactory.getLogger(ItemManiaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(ItemMania itemMania) throws Exception {
        log.info("Repository create()");

        String query = "insert into itemMania(" +
                "id, pw, nickname, item, price) values(?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, itemMania.getId(), itemMania.getPw(), itemMania.getNickname(),
                itemMania.getItem(), itemMania.getPrice());
    }

    public List<ItemMania> list() throws Exception {
        log.info("ItemManiaRepository list()");
        List<ItemMania> results = jdbcTemplate.query(
                "select board_num, id, pw, nickname, item, price from itemMania", new RowMapper<ItemMania>() {
                    @Override
                    public ItemMania mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ItemMania itemMania = new ItemMania();

                        itemMania.setBoardNum(rs.getInt("board_num"));
                        itemMania.setId(rs.getString("id"));
                        itemMania.setPw(rs.getString("pw"));
                        itemMania.setNickname(rs.getString("nickname"));
                        itemMania.setItem(rs.getString("item"));
                        itemMania.setPrice(rs.getInt("price"));
                        return itemMania;
                    }
                }
        );
        return results;
    }
    public ItemMania read(Integer boardNum) throws Exception{

        String query = "select * from itemMania where board_num = ?";
        List<ItemMania> results =  jdbcTemplate.query(query, new RowMapper<ItemMania>(){

            @Override
            public ItemMania mapRow(ResultSet rs, int rowNum) throws SQLException {

                ItemMania data = new ItemMania();
                data.setBoardNum(rs.getInt("board_num"));
                data.setId(rs.getString("id"));
                data.setPw(rs.getString("pw"));
                data.setNickname(rs.getString("nickname"));
                data.setItem(rs.getString("item"));
                data.setPrice(rs.getInt("price"));

                return data;
            }
        }, boardNum);
        return results.isEmpty() ? null : results.get(0);
    }
    public void remove(Integer boardNum) throws Exception{
        String query = "delete from itemMania where board_num = ?";
        jdbcTemplate.update(query, boardNum);
    }

    public void modify(ItemMania itemMania) throws Exception{
        String query= "update itemMania set item = ? , price = ?" + " where board_num = ?";
        jdbcTemplate.update(
                query, itemMania.getItem(), itemMania.getPrice(), itemMania.getBoardNum()
        );
    }
}