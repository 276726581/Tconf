package com.timogroup.tconf.controller;

import com.timogroup.tconf.dto.ResponseData;
import com.timogroup.tconf.entity.Props;
import com.timogroup.tconf.service.PropsService;
import com.timogroup.tconf.util.RequestMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Controller
@RequestMapping("/props")
public class PropsController extends BaseController {

    @Resource
    private PropsService propsService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData getList() {
        ResponseData data = new ResponseData();
        try {
            List<Props> list = propsService.findAll();
            data.setStatus(200);
            data.setData(list);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseData getItem(@PathVariable("id") Integer id) {
        ResponseData data = new ResponseData();
        try {
            Props props = propsService.findPropsById(id);
            data.setStatus(200);
            data.setData(props);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    @ResponseBody
    public ResponseData updateItem(@PathVariable("id") Integer id,
                                   @RequestBody Map<String, String> map) {
        ResponseData data = new ResponseData();
        try {
            RequestMap requestMap = new RequestMap(map);
            String name = requestMap.getAsString("name");
            String properties = requestMap.getAsString("props");

            Props props = new Props();
            props.setId(id);
            props.setName(name);
            props.setProperties(properties);
            propsService.updateProps(props);
            data.setStatus(200);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public ResponseData updateItem(@PathVariable("id") Integer id) {
        ResponseData data = new ResponseData();
        try {
            propsService.deleteProps(id);
            data.setStatus(200);
        } catch (Exception e) {
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }
}
