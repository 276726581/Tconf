package com.timogroup.tconf.controller;

import com.timogroup.tconf.dto.ResponseData;
import com.timogroup.tconf.entity.User;
import com.timogroup.tconf.exception.BusinessException;
import com.timogroup.tconf.service.UserService;
import com.timogroup.tconf.util.RequestMap;
import com.timogroup.tconf.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseData login(@RequestBody Map<String, String> map) {
        RequestMap requestMap = new RequestMap(map);
        String userName = requestMap.getAsString("username");
        String passWord = requestMap.getAsString("password");

        ResponseData data = new ResponseData();
        try {
            User user = userService.login(userName, passWord);
            data.setStatus(200);
            data.setData(user.getId());
        } catch (BusinessException e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/admin.do")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @RequestMapping("/edit.do")
    public ModelAndView edit(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping("/logout.do")
    public ModelAndView logout() {
        SessionUtil.getSession().invalidate();
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
