package com.acg_shop.dao;

import com.acg_shop.MyWebInitializer;
import com.acg_shop.config.SpringDaoConfig;
import com.acg_shop.config.SpringWebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * GoodDaoTest
 * Created by mac_zly on 2017/5/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(initializers = MyWebInitializer.class)
public class GoodDaoTest {

    @Autowired
//    private GoodDao goodDao;

    @Test
    public void queryAll() throws Exception {

    }

}