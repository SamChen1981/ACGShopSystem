package com.acg_shop.service;

import com.acg_shop.entity.Good;

import java.util.List;

/**
 * 商品接口
 * Created by mac_zly on 2017/5/18.
 */

public interface IGoodService {

    List<Good> queryAll(Integer limit, Integer offset);

    int insert(Good good);

}
