package com.acg_shop.controller.ui;

import com.acg_shop.dao.GoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面跳转
 * Created by mac_zly on 2017/4/18.
 */

@Controller
public class UIController {

    @Autowired
    private GoodDao goodDao;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("goods", goodDao.queryAll());
        return "Welcome";
    }

    @RequestMapping(value = {"/goods"}, method = RequestMethod.GET)
    public String goods(Model model) {
        model.addAttribute("goods", goodDao.queryAll());
        return "shop/goods";
    }

    @RequestMapping("/search")
    public String search(String keyword) {

        return "shop/goods";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
