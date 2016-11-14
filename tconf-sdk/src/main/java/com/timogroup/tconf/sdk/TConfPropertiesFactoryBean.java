package com.timogroup.tconf.sdk;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Properties;

/**
 * Created by TimoRD on 2016/11/14.
 */
public class TConfPropertiesFactoryBean implements FactoryBean<Properties>, InitializingBean {

    private PropertiesLoader loader;
    private String uuid;

    private Properties properties;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public TConfPropertiesFactoryBean(String host, int port) {
        loader = new PropertiesLoader(host, port);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        properties = loader.getProperties(uuid);
    }

    @Override
    public Properties getObject() throws Exception {
        return properties;
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
