package com.acg_shop.service;

import com.acg_shop.entity.Good;

import java.util.List;

/**
 * 商品接口
 * Created by mac_zly on 2017/5/18.
 */

public interface IGoodService {

    /**
     * 查询全部
     *
     * @param limit  limit
     * @param offset offset
     * @return 返回结果
     */
    List<Good> queryAll(Integer limit, Integer offset);

    /**
     * 插入数据
     *
     * @param good 商品
     * @return 插入的条数 1
     */
    int insert(Good good);

    /**
     * 删除商品
     *
     * @param goodId 商品Id
     * @return 返回删除的条数1
     */
    int delete(Integer goodId);

}
