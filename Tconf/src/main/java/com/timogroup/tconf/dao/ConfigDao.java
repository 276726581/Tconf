package com.timogroup.tconf.dao;

import com.timogroup.tconf.entity.Config;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface ConfigDao {

    void save(Config config);

    void update(Config config);

    void deleteById(Integer id);

    Config findById(Integer id);

    Config findByUUID(String uuid);

    List<Config> findAll();
}
