package com.timogroup.tconf.sdk;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by TimoRD on 2016/11/14.
 */
public class PropertiesLoaderTest {

    @Test
    public void test() {
        PropertiesLoader loader = new PropertiesLoader("127.0.0.1", 8080);
        Properties properties = loader.getProperties("64fc64a7-c4a6-4963-a60e-1e0e4141c117");
        System.out.println();
    }

    @Test
    public void spring() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        ctx.start();
    }
}
