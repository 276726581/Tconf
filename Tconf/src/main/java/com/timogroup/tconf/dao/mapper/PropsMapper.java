package com.timogroup.tconf.dao.mapper;

import com.timogroup.tconf.entity.Props;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface PropsMapper {

    void save(Props props);

    void update(Props props);

    void deleteById(@Param("id") Integer id);

    Props findById(@Param("id") Integer id);

    Props findByUUID(@Param("uuid") String uuid);

    List<Props> findAll();
}
