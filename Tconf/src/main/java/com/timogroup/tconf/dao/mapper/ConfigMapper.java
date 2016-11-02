package com.timogroup.tconf.dao.mapper;

import com.timogroup.tconf.entity.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface ConfigMapper {

    void save(Config config);

    void update(Config config);

    void deleteById(@Param("id") Integer id);

    Config findById(@Param("id") Integer id);

    Config findByUUID(@Param("uuid") String uuid);

    List<Config> findAll();
}
