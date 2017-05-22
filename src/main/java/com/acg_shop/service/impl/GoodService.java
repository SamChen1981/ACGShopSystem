package com.acg_shop.service.impl;

import com.acg_shop.dao.GoodDao;
import com.acg_shop.entity.Good;
import com.acg_shop.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务类
 * Created by mac_zly on 2017/5/18.
 */

@Service
public class GoodService implements IGoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public List<Good> queryAll(Integer limit, Integer offset) {
        return goodDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(Good good) {
        return goodDao.insert(good);
    }

    @Override
    public int delete(Integer goodId) {
        return goodDao.delete(goodId);
    }
}
