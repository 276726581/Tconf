package com.timogroup.tconf.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by TimoRD on 2016/10/31.
 */
public class BaseController {

    @ExceptionHandler
    @ResponseBody
    public String exception(Exception e) {
        String msg = e.getMessage();
        return msg;
    }
}
