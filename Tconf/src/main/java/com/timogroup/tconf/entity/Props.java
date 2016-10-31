package com.timogroup.tconf.entity;

import java.io.Serializable;

/**
 * Created by TimoRD on 2016/10/31.
 */
public class Props implements Serializable {

    private Integer id;
    private String name;
    private String uuid;
    private String properties;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Props() {
    }

    @Override
    public String toString() {
        return "ServiceProps{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", properties='" + properties + '\'' +
                '}';
    }
}
