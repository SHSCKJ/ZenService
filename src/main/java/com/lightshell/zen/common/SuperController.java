package com.lightshell.zen.common;

import java.util.LinkedHashMap;

public class SuperController {

    protected LinkedHashMap<String, Object> map = new LinkedHashMap();

    protected boolean isAuthorized(String appid, String token) {
        return true;
    }

}
