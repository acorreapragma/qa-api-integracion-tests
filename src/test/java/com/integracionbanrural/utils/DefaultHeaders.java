package com.integracionbanrural.utils;

import java.util.HashMap;
import java.util.Map;

public class DefaultHeaders {

    public static Map<String, String> basicJsonHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }

}
