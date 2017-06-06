package com.acg_shop.dao;

import com.acg_shop.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * GoodDaoImpl 使用Spring的JdbcTemplate
 * Created by mac_zly on 2017/6/6.
 */

//@Repository
//@Primary // 首选Bean
//@Qualifier("JdbcTemplate-Impl")
public class GoodDaoImpl // implements GoodDao
{

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    //@Override
    public List<Good> queryAll() {
        List<Good> list = new ArrayList<>();
        jdbcTemplate.query("SELECT id, good_id, good_name, good_description, good_pic FROM goods_table", resultSet -> {
            Good good = new Good();
            good.setId(resultSet.getInt(resultSet.findColumn("id")));
            good.setGoodId(resultSet.getInt(resultSet.findColumn("good_id")));
            good.setGoodName(resultSet.getString(resultSet.findColumn("good_name")));
            good.setGoodDescription(resultSet.getString(resultSet.findColumn("good_description")));
            good.setGoodPic(resultSet.getString(resultSet.findColumn("good_pic")));
            list.add(good);
        });
        return list;
    }

    //@Override
    public int insert(Good good) {
        int i = jdbcTemplate.update(
                "INSERT INTO goods_table (good_name, good_id, good_description, good_pic) VALUES (?,?,?,?)",
                good.getGoodName(), good.getGoodId(), good.getGoodDescription(), good.getGoodPic());
        return i;
    }

   // @Override
    public int delete(Integer goodId) {
        return jdbcTemplate.update("DELETE FROM goods_table WHERE good_id = ?", goodId);
    }
}
