package com.timogroup.tconf.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by TimoRD on 2016/8/10.
 */
public final class SessionUtil {

    private SessionUtil() {

    }

    public static HttpSession getSession() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return session;
    }

    public static void setAttribute(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    public static Object getAttribute(String name) {
        Object attribute = getSession().getAttribute(name);
        return attribute;
    }
}
