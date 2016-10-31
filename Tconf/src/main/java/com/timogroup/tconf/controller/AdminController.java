package com.timogroup.tconf.controller;

import com.timogroup.tconf.entity.User;
import com.timogroup.tconf.exception.BusinessException;
import com.timogroup.tconf.service.UserService;
import com.timogroup.tconf.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView login(@RequestParam("userName") String userName,
                              @RequestParam("passWord") String passWord) {

        ModelAndView mv = new ModelAndView("admin");
        try {
            User user = userService.login(userName, passWord);
            SessionUtil.setAttribute("user", user);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView logout() {
        SessionUtil.getSession().invalidate();
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
