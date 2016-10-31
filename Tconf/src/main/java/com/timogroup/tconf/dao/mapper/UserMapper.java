package com.timogroup.tconf.dao.mapper;

import com.timogroup.tconf.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface UserMapper {

    void save(User user);

    void update(User user);

    void deleteById(@Param("id") Integer id);

    User findById(@Param("id") Integer id);

    User findByUserNameAndPassWord(@Param("userName") String userName, @Param("passWord") String passWord);

    List<User> findAll();

    int findCountByUserName(@Param("userName") String userName);
}
