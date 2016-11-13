package com.timogroup.tconf;

import com.timogroup.tconf.entity.Props;
import com.timogroup.tconf.exception.BusinessException;
import com.timogroup.tconf.service.PropsService;
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
public class PropsServiceTest {

    @Resource(name = "configService")
    private PropsService propsService;

    @Test
    public void saveProps() throws BusinessException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("username=ad");
        buffer.append(System.lineSeparator());
        buffer.append("password=ad");
        String content = buffer.toString();

        Props props = new Props();
        props.setName("test");
        props.setContent(content);
        propsService.saveProps(props);
        System.out.println();
    }

    @Test
    public void update() throws BusinessException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("db.driver=com.mysql.jdbc.Driver");
        String content = buffer.toString();

        Props props = new Props();
        props.setId(1);
        props.setName("test");
        props.setContent(content);
        propsService.updateProps(props);
        System.out.println();
    }

    @Test
    public void findAll() {
        List<Props> list = propsService.findAll();
        System.out.println();
    }

    @Test
    public void deleteUser() {
        Props props = propsService.findPropsByUUID("be146af8-e86a-42d2-affa-67a753796cde");
        System.out.println();
    }
}
