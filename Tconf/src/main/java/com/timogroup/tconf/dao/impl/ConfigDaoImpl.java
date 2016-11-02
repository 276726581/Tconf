package com.timogroup.tconf.dao.impl;

import com.timogroup.tconf.dao.ConfigDao;
import com.timogroup.tconf.dao.mapper.ConfigMapper;
import com.timogroup.tconf.entity.Config;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Repository("configDao")
public class ConfigDaoImpl implements ConfigDao {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public void save(Config config) {
        configMapper.save(config);
    }

    @Override
    public void update(Config config) {
        configMapper.update(config);
    }

    @Override
    public void deleteById(Integer id) {
        configMapper.deleteById(id);
    }

    @Override
    public Config findById(Integer id) {
        Config config = configMapper.findById(id);
        return config;
    }

    @Override
    public Config findByUUID(String uuid) {
        Config config = configMapper.findByUUID(uuid);
        return config;
    }

    @Override
    public List<Config> findAll() {
        List<Config> list = configMapper.findAll();
        return list;
    }
}
