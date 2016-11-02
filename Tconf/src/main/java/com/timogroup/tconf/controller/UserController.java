package com.timogroup.tconf.controller;

import com.timogroup.tconf.dto.ResponseData;
import com.timogroup.tconf.entity.User;
import com.timogroup.tconf.service.UserService;
import com.timogroup.tconf.util.BeanMapUtil;
import com.timogroup.tconf.util.RequestMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TimoRD on 2016/11/1.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public ResponseData getUserList() {
        ResponseData data = new ResponseData();
        try {
            List<User> list = userService.getUserList();
            List<Map<String, Object>> mapList = new ArrayList<>();
            for (User user : list) {
                Map<String, Object> beanMap = BeanMapUtil.getPropertyMap(user, "id", "userName");
                mapList.add(beanMap);
            }
            data.setStatus(200);
            data.setData(list);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseData addUser(@RequestBody Map<String, String> map) {
        ResponseData data = new ResponseData();
        try {
            RequestMap requestMap = new RequestMap(map);
            String username = requestMap.getAsString("username");
            String password = requestMap.getAsString("password");

            User user = new User();
            user.setUserName(username);
            user.setPassWord(password);
            userService.register(user);

            Map<String, Object> beanMap = BeanMapUtil.getPropertyMap(user, "id", "userName");
            data.setStatus(200);
            data.setData(beanMap);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    @ResponseBody
    public ResponseData updateUser(@PathVariable("id") Integer id, @RequestBody Map<String, String> map) {
        ResponseData data = new ResponseData();
        try {
            RequestMap requestMap = new RequestMap(map);
            String password = requestMap.getAsString("password");
            userService.updateWord(id, password);
            data.setStatus(200);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public ResponseData deleteUser(@PathVariable("id") Integer id) {
        ResponseData data = new ResponseData();
        try {
            userService.deleteUser(id);
            data.setStatus(200);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }
}
