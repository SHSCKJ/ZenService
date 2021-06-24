package com.lightshell.zen.common;

import java.util.LinkedHashMap;

/**
 * @author kevindong
 */
public abstract class AbstractController {

    protected LinkedHashMap<String, Object> map = new LinkedHashMap();

    protected boolean isAuthorized(String appid, String token) {
        return true;
    }

}
