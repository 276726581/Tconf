package com.timogroup.tconf.dao;

import com.timogroup.tconf.entity.Props;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface PropsDao {

    void save(Props props);

    void update(Props props);

    void deleteById(Integer id);

    Props findById(Integer id);

    Props findByUUID(String uuid);

    List<Props> findAll();
}
