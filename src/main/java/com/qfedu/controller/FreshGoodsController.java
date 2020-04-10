package com.qfedu.controller;

import com.qfedu.entity.FreshGoods;
import com.qfedu.service.FreshGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (FreshGoods)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
@RequestMapping("freshGoods")
public class FreshGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private FreshGoodsService freshGoodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public FreshGoods selectOne(String id) {
        return this.freshGoodsService.queryById(id);
    }

}