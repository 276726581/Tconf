package com.timogroup.tconf.support;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Created by TimoRD on 2016/11/14.
 */
public class StringHttpMessageConverter extends AbstractHttpMessageConverter<String> {

    public final static Charset UTF8 = Charset.forName("UTF-8");

    @Override
    protected boolean supports(Class<?> clazz) {
        if (String.class.equals(clazz)) {
            return true;
        }
        return false;
    }

    @Override
    protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();
        int available = inputStream.available();
        byte[] bytes = new byte[available];
        inputStream.read(bytes);
        String s = new String(bytes, UTF8);

        return s;
    }

    @Override
    protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream out = outputMessage.getBody();
        byte[] bytes = s.getBytes(UTF8);
        out.write(bytes);
    }
}
