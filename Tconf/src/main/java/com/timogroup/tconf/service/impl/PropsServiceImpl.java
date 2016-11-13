package com.timogroup.tconf.service.impl;

import com.timogroup.tconf.dao.PropsDao;
import com.timogroup.tconf.entity.Props;
import com.timogroup.tconf.service.PropsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Service("propsService")
public class PropsServiceImpl implements PropsService {

    @Resource
    private PropsDao propsDao;

    @Override
    public void saveProps(Props props) {
        String uuid = UUID.randomUUID().toString();
        props.setUuid(uuid);
        propsDao.save(props);
    }

    @Override
    public void updateProps(Props props) {
        propsDao.update(props);
    }

    @Override
    public void deleteProps(Integer id) {
        propsDao.deleteById(id);
    }

    @Override
    public Props findPropsById(Integer id) {
        Props props = propsDao.findById(id);
        return props;
    }

    @Override
    public Props findPropsByUUID(String uuid) {
        Props props = propsDao.findByUUID(uuid);
        return props;
    }

    @Override
    public List<Props> findAll() {
        List<Props> list = propsDao.findAll();
        return list;
    }
}
