package com.timogroup.tconf.dao;

import com.timogroup.tconf.entity.User;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface UserDao {

    void save(User user);

    void update(User user);

    void deleteById(Integer id);

    User findById(Integer id);

    User findByUserNameAndPassWord(String userName, String passWord);

    List<User> findAll();

    int findCountByUserName(String userName);
}
