package com.qfedu.controller;

import com.qfedu.entity.RolePerm;
import com.qfedu.service.RolePermService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RolePerm)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:08
 */
@RestController
@RequestMapping("rolePerm")
public class RolePermController {
    /**
     * 服务对象
     */
    @Resource
    private RolePermService rolePermService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RolePerm selectOne(Integer id) {
        return this.rolePermService.queryById(id);
    }

}