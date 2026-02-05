package com.integracionbanrural.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HeaderResolver {

    public static Map<String, String> resolve(Map<String, String> headers) {
        Map<String, String> resolvedHeaders = new HashMap<>(headers);
        resolvedHeaders.replaceAll((k, v) -> {
            if ("{{$uuid}}".equalsIgnoreCase(v)) {
                return UUID.randomUUID().toString();
            }
            return v;
        });
        return resolvedHeaders;
    }

}
