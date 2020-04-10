package com.qfedu.controller;

import com.qfedu.entity.EmpRole;
import com.qfedu.service.EmpRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EmpRole)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@RestController
@RequestMapping("empRole")
public class EmpRoleController {
    /**
     * 服务对象
     */
    @Resource
    private EmpRoleService empRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EmpRole selectOne(Integer id) {
        return this.empRoleService.queryById(id);
    }

}