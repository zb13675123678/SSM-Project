package com.qfedu.entity;

import lombok.Data;

/**
 * CartItem（购物车条目）
 * @auther Zhangbo
 * @date 2020/4/12 16:42
 */
@Data
public class CartItem {

    private FreshGoods freshGoods;
    private int count;

}
