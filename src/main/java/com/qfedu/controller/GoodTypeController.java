package com.qfedu.controller;

import com.qfedu.entity.GoodType;
import com.qfedu.service.GoodTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodType)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
public class GoodTypeController {
    /**
     * 服务对象
     */
    @Resource
    private GoodTypeService goodTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   // @GetMapping("selectOne")
    public GoodType selectOne(Integer id) {
        return this.goodTypeService.queryById(id);
    }


    @GetMapping("getAllGoodsTypeByPage")
    public List<GoodType> getAllByPage(){

        return goodTypeService.queryAllByLimit(0,100);
    }
}