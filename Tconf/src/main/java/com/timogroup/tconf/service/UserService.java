package com.timogroup.tconf.service;

import com.timogroup.tconf.entity.User;
import com.timogroup.tconf.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
public interface UserService {

    @Transactional
    void register(User user) throws BusinessException;

    @Transactional
    User login(String userName, String passWord) throws BusinessException;

    void updateWord(Integer id, String passWord);

    void deleteUser(Integer id);

    List<User> getUserList();
}
