package com.qfedu.service;

import com.qfedu.entity.Citys;
import java.util.List;

/**
 * (Citys)表服务接口
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public interface CitysService {

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    Citys queryById(Integer cid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Citys> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param citys 实例对象
     * @return 实例对象
     */
    Citys insert(Citys citys);

    /**
     * 修改数据
     *
     * @param citys 实例对象
     * @return 实例对象
     */
    Citys update(Citys citys);

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cid);

}