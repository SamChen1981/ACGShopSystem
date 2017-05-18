package com.acg_shop.controller;

import com.acg_shop.entity.Good;
import com.acg_shop.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制器
 * Created by mac_zly on 2017/4/18.
 */

@Controller
@RequestMapping("/goods")
public class GoodController {

    @Autowired
    private IGoodService goodService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Integer add(Good good) {
        return goodService.insert(good);
    }

}
