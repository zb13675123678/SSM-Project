package com.qfedu.controller;

import com.qfedu.entity.Permissions;
import com.qfedu.service.PermissionsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Permissions)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
@RequestMapping("permissions")
public class PermissionsController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionsService permissionsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permissions selectOne(Integer id) {
        return this.permissionsService.queryById(id);
    }

}