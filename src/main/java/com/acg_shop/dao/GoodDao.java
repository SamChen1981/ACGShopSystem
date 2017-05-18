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

    List<Good> queryAll();

    int insert(Good good);

}
