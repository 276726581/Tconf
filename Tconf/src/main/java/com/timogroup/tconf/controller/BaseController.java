package com.timogroup.tconf.controller;

import com.timogroup.tconf.dto.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by TimoRD on 2016/10/31.
 */
public class BaseController {

    @ExceptionHandler
    @ResponseBody
    public ResponseData exception(Exception e) {
        ResponseData data = new ResponseData();
        data.setStatus(500);
        data.setMsg(e.getMessage());

        return data;
    }
}
