package com.timogroup.tconf.controller;

import com.timogroup.tconf.dto.ResponseData;
import com.timogroup.tconf.entity.Props;
import com.timogroup.tconf.service.PropsService;
import com.timogroup.tconf.util.BeanMapUtil;
import com.timogroup.tconf.util.RequestMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Created by TimoRD on 2016/10/31.
 */
@Controller
@RequestMapping("/props")
public class PropsController extends BaseController {

    private static Logger logger = Logger.getLogger(PropsController.class);

    @Resource
    private PropsService propsService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseData getList() {
        ResponseData data = new ResponseData();
        try {
            List<Props> list = propsService.findAll();
            data.setStatus(200);
            data.setData(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseData postItem(@RequestBody Map<String, String> map) {
        ResponseData data = new ResponseData();
        try {
            RequestMap requestMap = new RequestMap(map);
            String name = requestMap.getAsString("name");
            String content = requestMap.getAsString("content", "");
            Props props = new Props();
            props.setName(name);
            props.setContent(content);
            propsService.saveProps(props);
            data.setStatus(200);
            data.setData(props);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
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
            logger.error(e.getMessage(), e);
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }

    @RequestMapping(value = "/{id}/map", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseData getItemMap(@PathVariable("id") Integer id) {
        ResponseData data = new ResponseData();
        try {
            Props props = propsService.findPropsById(id);
            Map<String, Object> map = BeanMapUtil.getPropertyMap(props, "id", "name", "uuid", "content");

            List<Map<String, Object>> mapList = new ArrayList<>();
            try {
                Properties properties = new Properties();
                ByteArrayInputStream inputStream = new ByteArrayInputStream(props.getContent().getBytes());
                properties.load(inputStream);
                for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    Map<String, Object> item = new HashMap<>();
                    item.put("key", key);
                    item.put("value", value);
                    mapList.add(item);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            map.put("props", mapList);

            data.setStatus(200);
            data.setData(map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
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
            String content = requestMap.getAsString("content", "");

            Props props = new Props();
            props.setId(id);
            props.setName(name);
            props.setContent(content);
            propsService.updateProps(props);
            data.setStatus(200);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
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
            logger.error(e.getMessage(), e);
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }
}
