package com.timogroup.tconf;

import com.timogroup.tconf.entity.User;
import com.timogroup.tconf.exception.BusinessException;
import com.timogroup.tconf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.annotation.CachePut;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by TimoRD on 2016/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/app.xml")
public class UserServiceTest {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void register() throws BusinessException {
        User user = new User();
        user.setUserName("admin");
        user.setPassWord("admin");
        userService.register(user);
        System.out.println();
    }

    @Test
    public void login() throws BusinessException {
        User user = userService.login("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void updatePassWord() {
        userService.updateWord(1, "ad");
        System.out.println();
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(1);
        userService.deleteUser(8);
        System.out.println();
    }
}
