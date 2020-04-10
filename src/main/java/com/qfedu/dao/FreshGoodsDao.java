package com.qfedu.dao;

import com.qfedu.entity.FreshGoods;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (FreshGoods)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
public interface FreshGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fdid 主键
     * @return 实例对象
     */
    FreshGoods queryById(String fdid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<FreshGoods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param freshGoods 实例对象
     * @return 对象列表
     */
    List<FreshGoods> queryAll(FreshGoods freshGoods);

    /**
     * 新增数据
     *
     * @param freshGoods 实例对象
     * @return 影响行数
     */
    int insert(FreshGoods freshGoods);

    /**
     * 修改数据
     *
     * @param freshGoods 实例对象
     * @return 影响行数
     */
    int update(FreshGoods freshGoods);

    /**
     * 通过主键删除数据
     *
     * @param fdid 主键
     * @return 影响行数
     */
    int deleteById(String fdid);

}