package com.qfedu.service.impl;

import com.qfedu.entity.Citys;
import com.qfedu.dao.CitysDao;
import com.qfedu.service.CitysService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Citys)表服务实现类
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@Service("citysService")
public class CitysServiceImpl implements CitysService {
    @Resource
    private CitysDao citysDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    @Override
    public Citys queryById(Integer cid) {
        return this.citysDao.queryById(cid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Citys> queryAllByLimit(int offset, int limit) {
        return this.citysDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param citys 实例对象
     * @return 实例对象
     */
    @Override
    public Citys insert(Citys citys) {
        this.citysDao.insert(citys);
        return citys;
    }

    /**
     * 修改数据
     *
     * @param citys 实例对象
     * @return 实例对象
     */
    @Override
    public Citys update(Citys citys) {
        this.citysDao.update(citys);
        return this.queryById(citys.getCid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cid) {
        return this.citysDao.deleteById(cid) > 0;
    }
}