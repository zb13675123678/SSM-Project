package com.qfedu.service.impl;

import com.qfedu.entity.Province;
import com.qfedu.dao.ProvinceDao;
import com.qfedu.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Province)表服务实现类
 *
 * @author makejava
 * @since 2020-04-10 13:49:08
 */
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    private ProvinceDao provinceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Province queryById(Integer pid) {
        return this.provinceDao.queryById(pid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Province> queryAllByLimit(int offset, int limit) {
        return this.provinceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param province 实例对象
     * @return 实例对象
     */
    @Override
    public Province insert(Province province) {
        this.provinceDao.insert(province);
        return province;
    }

    /**
     * 修改数据
     *
     * @param province 实例对象
     * @return 实例对象
     */
    @Override
    public Province update(Province province) {
        this.provinceDao.update(province);
        return this.queryById(province.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pid) {
        return this.provinceDao.deleteById(pid) > 0;
    }
}