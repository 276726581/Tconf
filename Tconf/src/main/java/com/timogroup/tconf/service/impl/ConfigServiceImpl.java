package com.timogroup.tconf.service.impl;

import com.timogroup.tconf.dao.ConfigDao;
import com.timogroup.tconf.entity.Config;
import com.timogroup.tconf.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigDao configDao;

    @Override
    public void saveProps(Config config) {
        String uuid = UUID.randomUUID().toString();
        config.setUuid(uuid);
        configDao.save(config);
    }

    @Override
    public void updateProps(Config config) {
        configDao.update(config);
    }

    @Override
    public void deleteProps(Integer id) {
        configDao.deleteById(id);
    }

    @Override
    public Config findPropsById(Integer id) {
        Config config = configDao.findById(id);
        return config;
    }

    @Override
    public Config findPropsByUUID(String uuid) {
        Config config = configDao.findByUUID(uuid);
        return config;
    }

    @Override
    public List<Config> findAll() {
        List<Config> list = configDao.findAll();
        return list;
    }
}
