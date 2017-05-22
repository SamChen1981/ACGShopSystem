package com.acg_shop.controller;

import com.acg_shop.dto.ResultDto;
import com.acg_shop.entity.Good;
import com.acg_shop.enums.ResultEnum;
import com.acg_shop.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 * Created by mac_zly on 2017/4/18.
 */

@RestController
@RequestMapping("/goods")
public class GoodController {

    @Autowired
    private IGoodService goodService;

    /**
     * 增加一个商品类型
     *
     * @param good 商品
     * @return 返回结果
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultDto add(Good good) {
        int i = goodService.insert(good);
        if (i == 1) {
            return new ResultDto(ResultEnum.QUERY_SUCCESS, true);
        } else {
            return new ResultDto(ResultEnum.QUERY_FAILD, false);
        }
    }

    /**
     * 删除商品
     *
     * @param goodId 商品ID
     */
    @RequestMapping(value = "/del/{goodId}", method = RequestMethod.POST)
    public ResultDto del(@PathVariable("goodId") Integer goodId) {
        int i = goodService.delete(goodId);
        if (i == 1) {
            return new ResultDto(ResultEnum.QUERY_SUCCESS, true);
        } else {
            return new ResultDto(ResultEnum.QUERY_FAILD, false);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto update() {

        return null;
    }

}
