package com.qfedu.controller;

import com.qfedu.entity.Citys;
import com.qfedu.service.CitysService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Citys)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
@RequestMapping("citys")
public class CitysController {
    /**
     * 服务对象
     */
    @Resource
    private CitysService citysService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Citys selectOne(Integer id) {
        return this.citysService.queryById(id);
    }

}