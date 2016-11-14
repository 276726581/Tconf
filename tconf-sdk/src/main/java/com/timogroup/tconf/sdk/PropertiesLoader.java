package com.timogroup.tconf.sdk;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * Created by TimoRD on 2016/11/14.
 */
public class PropertiesLoader {

    private String host;
    private int port;

    public PropertiesLoader(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Properties getProperties(String id) {
        Properties properties = new Properties();

        InputStream inputStream = null;
        try {
            URL url = new URL(String.format("http://%s:%d/api/props/%s", host, port, id));
            URLConnection connection = url.openConnection();

            inputStream = connection.getInputStream();
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            ByteArrayInputStream input = new ByteArrayInputStream(bytes);
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;
    }
}
