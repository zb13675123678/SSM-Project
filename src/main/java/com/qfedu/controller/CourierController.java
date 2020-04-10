package com.qfedu.controller;

import com.qfedu.entity.Courier;
import com.qfedu.service.CourierService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Courier)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
@RequestMapping("courier")
public class CourierController {
    /**
     * 服务对象
     */
    @Resource
    private CourierService courierService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Courier selectOne(String id) {
        return this.courierService.queryById(id);
    }

}