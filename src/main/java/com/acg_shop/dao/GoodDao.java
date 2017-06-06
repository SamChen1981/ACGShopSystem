package com.acg_shop.dao;

import com.acg_shop.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * 商品DAO
 * Created by mac_zly on 2017/4/24.
 */

@Repository
// 还需要配合 @EnableJpaRepositories(basePackages = {"com.acg_shop.dao"})
public interface GoodDao extends JpaRepository<Good, Integer> {

    Good findByGoodId(Integer goodId);

    int countGoodsByGoodName(String goodName);

//    @Query("SELECT id, good_name, good_id, good_description, good_pic FROM goods_table WHERE good_name LIKE '%miku%'")
//    ArrayList<Good> findMiku();

    /**
     * 查询全部商品
     *//*
    List<Good> queryAll();

    *//**
     * 插入
     *
     * @param good 商品
     * @return 返回删除个数
     *//*
    int insert(Good good);

    *//**
     * 删除商品
     *
     * @param goodId 商品ID
     * @return 返回删除个数
     *//*
    int delete(Integer goodId);*/

}
