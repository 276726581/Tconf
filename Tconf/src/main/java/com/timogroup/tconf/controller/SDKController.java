package com.timogroup.tconf.controller;

import com.timogroup.tconf.entity.Props;
import com.timogroup.tconf.service.PropsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by TimoRD on 2016/11/14.
 */
@Controller
@RequestMapping("/api/props")
public class SdkController {

    private static Logger logger = Logger.getLogger(PropsController.class);

    @Resource
    private PropsService propsService;

    @RequestMapping(value = "/{uuid}", method = {RequestMethod.GET})
    @ResponseBody
    public String getItem(@PathVariable("uuid") String uuid) {
        String data = "";
        try {
            Props props = propsService.findPropsByUUID(uuid);
            data = props.getContent();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return data;
    }
}
