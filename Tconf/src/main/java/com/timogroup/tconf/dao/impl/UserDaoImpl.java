package com.timogroup.tconf.dao.impl;

import com.timogroup.tconf.dao.UserDao;
import com.timogroup.tconf.dao.mapper.UserMapper;
import com.timogroup.tconf.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    @Override
    public User findByUserNameAndPassWord(String userName, String passWord) {
        User user = userMapper.findByUserNameAndPassWord(userName, passWord);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        return list;
    }

    @Override
    public int findCountByUserName(String userName) {
        int count = userMapper.findCountByUserName(userName);
        return count;
    }
}
