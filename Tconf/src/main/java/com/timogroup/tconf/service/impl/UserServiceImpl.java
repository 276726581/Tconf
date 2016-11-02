package com.timogroup.tconf.service.impl;

import com.timogroup.tconf.dao.UserDao;
import com.timogroup.tconf.entity.User;
import com.timogroup.tconf.exception.BusinessException;
import com.timogroup.tconf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void register(User user) throws BusinessException {
        int count = userDao.findCountByUserName(user.getUserName());
        if (count > 0) {
            throw new BusinessException("用户已存在");
        }

        userDao.save(user);
    }

    @Override
    public User login(String userName, String passWord) throws BusinessException {
        int count = userDao.findCountByUserName(userName);
        if (count == 0) {
            throw new BusinessException("用户不存在");
        }

        User user = userDao.findByUserNameAndPassWord(userName, passWord);
        if (null == user) {
            throw new BusinessException("密码错误");
        }

        return user;
    }

    @Override
    public void updateWord(Integer id, String passWord) {
        User user = new User();
        user.setId(id);
        user.setPassWord(passWord);
        userDao.update(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getUserList() {
        List<User> list = userDao.findAll();
        return list;
    }
}
