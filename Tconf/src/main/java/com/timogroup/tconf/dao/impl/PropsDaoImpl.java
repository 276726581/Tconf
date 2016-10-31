package com.timogroup.tconf.dao.impl;

import com.timogroup.tconf.dao.PropsDao;
import com.timogroup.tconf.dao.mapper.PropsMapper;
import com.timogroup.tconf.entity.Props;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Repository("propsDao")
public class PropsDaoImpl implements PropsDao {

    @Resource
    private PropsMapper propsMapper;

    @Override
    public void save(Props props) {
        propsMapper.save(props);
    }

    @Override
    public void update(Props props) {
        propsMapper.update(props);
    }

    @Override
    public void deleteById(Integer id) {
        propsMapper.deleteById(id);
    }

    @Override
    public Props findById(Integer id) {
        Props props = propsMapper.findById(id);
        return props;
    }

    @Override
    public Props findByUUID(String uuid) {
        Props props = propsMapper.findByUUID(uuid);
        return props;
    }

    @Override
    public List<Props> findAll() {
        List<Props> list = propsMapper.findAll();
        return list;
    }
}
