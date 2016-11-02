package com.timogroup.tconf.service;

import com.timogroup.tconf.entity.Config;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface ConfigService {

    void saveProps(Config config);

    void updateProps(Config config);

    void deleteProps(Integer id);

    Config findPropsById(Integer id);

    Config findPropsByUUID(String uuid);

    List<Config> findAll();
}
