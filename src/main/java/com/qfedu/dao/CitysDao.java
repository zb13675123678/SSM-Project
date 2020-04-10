package com.qfedu.dao;

import com.qfedu.entity.Citys;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Citys)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public interface CitysDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    Citys queryById(Integer cid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Citys> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param citys 实例对象
     * @return 对象列表
     */
    List<Citys> queryAll(Citys citys);

    /**
     * 新增数据
     *
     * @param citys 实例对象
     * @return 影响行数
     */
    int insert(Citys citys);

    /**
     * 修改数据
     *
     * @param citys 实例对象
     * @return 影响行数
     */
    int update(Citys citys);

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 影响行数
     */
    int deleteById(Integer cid);

}