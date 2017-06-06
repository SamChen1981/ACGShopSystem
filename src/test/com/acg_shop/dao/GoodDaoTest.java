package com.acg_shop.dao;

import com.acg_shop.config.ScanConfig;
import com.acg_shop.config.SpringDaoConfig;
import com.acg_shop.config.SpringWebConfig;
import com.acg_shop.config.TransationManageConfig;
import com.acg_shop.entity.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * GoodDaoTest
 * Created by mac_zly on 2017/5/17.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDaoConfig.class, SpringWebConfig.class, TransationManageConfig.class, ScanConfig.class})
public class GoodDaoTest {

    @Autowired
//    @Qualifier("Hibernate-Impl")
    private GoodDao goodDao;

    @Test
    public void queryAll() throws Exception {
//        goodDao.queryAll().forEach(System.out::println);
        goodDao.findAll().forEach(System.out::println);
    }

    @Test
    public void insert() throws Exception {
//        Good good = new Good();
//        good.setGoodId(11223);
//        good.setGoodDescription("测试");
//        good.setGoodName("测试");
//        good.setGoodPic("/pic");
//        goodDao.insert(good);
    }

    @Test
    public void delete() throws Exception {
//        goodDao.delete(11223);
    }

}