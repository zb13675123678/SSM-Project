package com.qfedu.controller;

import com.qfedu.entity.Cart;
import com.qfedu.entity.CartItem;
import com.qfedu.entity.FreshGoods;
import com.qfedu.service.CartService;
import com.qfedu.service.FreshGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@Controller
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;

    @Resource
    private FreshGoodsService freshGoodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    /*@GetMapping("selectOne")*/
    public Cart selectOne(Integer id) {
        return this.cartService.queryById(id);
    }

    @PostMapping("mycart")
    public  String myCart(@RequestParam(value = "fdid") String fdid, HttpSession session){
        //获取session中购物车对象
        Object objcart = session.getAttribute("cart");

        //1,购物车不存在
        if(objcart == null){
            /*购物车*/
            Map<String, CartItem> cart = new HashMap<>(20);
            /*商品条目*/
            CartItem cartItem = new CartItem();
            /*商品详情*/
            FreshGoods fg =freshGoodsService.queryById(fdid);

            cartItem.setCount(1);
            cartItem.setFreshGoods(fg);
            cart.put(fdid,cartItem);
            session.setAttribute("cart",cart);

        //2,购物车存在
        }else {
            Map<String, CartItem> cart = (Map<String, CartItem>) objcart;

            //2.1,购物车存在该商品
            if (cart.containsKey(fdid)) {
                CartItem cartItem = cart.get(fdid);
                cartItem.setCount(cartItem.getCount()+1);
                cart.put(fdid,cartItem);
                session.setAttribute("cart",cart);
            //3.2,购物车不存在该商品
            }else{
                CartItem cartItem = new CartItem();
                FreshGoods fg = freshGoodsService.queryById(fdid);
                cartItem.setCount(1);
                cartItem.setFreshGoods(fg);
                cart.put(fdid,cartItem);
                session.setAttribute("cart",cart);
            }
        }
        return "mycart";
    }
}