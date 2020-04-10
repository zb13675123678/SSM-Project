package com.qfedu.controller;

import com.qfedu.entity.Users;
import com.qfedu.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:08
 */
@RestController
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public Users selectOne(@PathVariable String id) {
        return this.usersService.queryById(id);
    }

    /**
     *
     * @param currentPage 当前页
     * @param pageSize    当前页记录数
     * @return
     */
    @GetMapping("selectByPage")
    public List<Users> getUsersBYPage(@RequestParam(value = "cp",defaultValue ="1") Integer currentPage,
                                      @RequestParam(value = "ps",defaultValue ="5") Integer pageSize){

        currentPage = currentPage < 1 ? 1 : currentPage;
        pageSize = pageSize < 1 ? 5 :pageSize;

        int offset = (currentPage-1)*pageSize;

        List<Users> list = usersService.queryAllByLimit(offset,pageSize);

        return list;
    }
}