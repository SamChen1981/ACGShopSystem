package com.acg_shop.dao;

import com.acg_shop.entity.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品DAO
 * Created by mac_zly on 2017/4/24.
 */

@Repository
public interface GoodDao {

    /**
     * 查询全部商品
     */
    List<Good> queryAll();

    /**
     * 插入
     *
     * @param good 商品
     * @return 返回删除个数
     */
    int insert(Good good);

    /**
     * 删除商品
     *
     * @param goodId 商品ID
     * @return 返回删除个数
     */
    int delete(Integer goodId);

}
