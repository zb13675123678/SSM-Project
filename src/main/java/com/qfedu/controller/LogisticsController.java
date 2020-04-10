package com.qfedu.controller;

import com.qfedu.entity.Logistics;
import com.qfedu.service.LogisticsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Logistics)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
@RequestMapping("logistics")
public class LogisticsController {
    /**
     * 服务对象
     */
    @Resource
    private LogisticsService logisticsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Logistics selectOne(Integer id) {
        return this.logisticsService.queryById(id);
    }

}