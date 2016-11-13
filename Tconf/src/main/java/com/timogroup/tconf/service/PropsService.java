package com.timogroup.tconf.service;

import com.timogroup.tconf.entity.Props;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface PropsService {

    void saveProps(Props props);

    void updateProps(Props props);

    void deleteProps(Integer id);

    Props findPropsById(Integer id);

    Props findPropsByUUID(String uuid);

    List<Props> findAll();
}
