package com.timogroup.tconf.controller;

import com.timogroup.tconf.dto.ResponseData;
import com.timogroup.tconf.entity.Config;
import com.timogroup.tconf.service.ConfigService;
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
@RequestMapping("/config")
public class ConfigController extends BaseController {

    private static Logger logger = Logger.getLogger(ConfigController.class);

    @Resource
    private ConfigService configService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    @ResponseBody
    public ResponseData getList() {
        ResponseData data = new ResponseData();
        try {
            List<Config> list = configService.findAll();
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
    public ResponseData getItem(@RequestBody Map<String, String> map) {
        ResponseData data = new ResponseData();
        try {
            RequestMap requestMap = new RequestMap(map);
            String name = requestMap.getAsString("name");
            String content = requestMap.getAsString("content", "");
            Config config = new Config();
            config.setName(name);
            config.setContent(content);
            configService.saveProps(config);
            data.setStatus(200);
            data.setData(config);
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
            Config config = configService.findPropsById(id);
            data.setStatus(200);
            data.setData(config);
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
            Config config = configService.findPropsById(id);
            Map<String, Object> map = BeanMapUtil.getPropertyMap(config, "id", "name", "uuid", "content");

            List<Map<String, Object>> mapList = new ArrayList<>();
            try {
                Properties properties = new Properties();
                ByteArrayInputStream inputStream = new ByteArrayInputStream(config.getContent().getBytes());
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

            Config config = new Config();
            config.setId(id);
            config.setName(name);
            config.setContent(content);
            configService.updateProps(config);
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
            configService.deleteProps(id);
            data.setStatus(200);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            data.setStatus(400);
            data.setMsg(e.getMessage());
        }

        return data;
    }
}
