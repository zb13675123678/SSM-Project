package com.qfedu.controller;

import com.qfedu.entity.CartItem;
import com.qfedu.entity.FreshGoods;
import com.qfedu.service.FreshGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @auther Zhangbo
 * @date 2020/4/14 3:11
 */
@Controller
public class PaymentController {

    @Resource
    private FreshGoodsService freshGoodsService;

    @PostMapping("payment")
    public  String payment(@RequestParam(value = "one",defaultValue = "") List<String> fds, HttpSession session){

        /*获取所有商品*/
        ArrayList<FreshGoods> freshGoodsList = new ArrayList<>();

        for (String fd: fds) {
            FreshGoods goods = freshGoodsService.queryById(fd);
            freshGoodsList.add(goods);
        }

        System.out.println("list"+fds.size());

        Object cartobj = session.getAttribute("cart");
        Map<String, CartItem> cart = cartobj == null ? null :((Map<String, CartItem>) cartobj);

        System.out.println("session"+cart.size());
        System.out.println(freshGoodsList);

        return "payment";
    }
}
