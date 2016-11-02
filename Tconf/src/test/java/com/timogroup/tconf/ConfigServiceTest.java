package com.timogroup.tconf;

import com.timogroup.tconf.entity.Config;
import com.timogroup.tconf.exception.BusinessException;
import com.timogroup.tconf.service.ConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TimoRD on 2016/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/app.xml")
public class ConfigServiceTest {

    @Resource(name = "configService")
    private ConfigService configService;

    @Test
    public void saveProps() throws BusinessException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("username=ad");
        buffer.append(System.lineSeparator());
        buffer.append("password=ad");
        String content = buffer.toString();

        Config config = new Config();
        config.setName("test");
        config.setContent(content);
        configService.saveProps(config);
        System.out.println();
    }

    @Test
    public void update() throws BusinessException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("db.driver=com.mysql.jdbc.Driver");
        String content = buffer.toString();

        Config config = new Config();
        config.setId(1);
        config.setName("test");
        config.setContent(content);
        configService.updateProps(config);
        System.out.println();
    }

    @Test
    public void findAll() {
        List<Config> list = configService.findAll();
        System.out.println();
    }

    @Test
    public void deleteUser() {
        Config config = configService.findPropsByUUID("be146af8-e86a-42d2-affa-67a753796cde");
        System.out.println();
    }
}
