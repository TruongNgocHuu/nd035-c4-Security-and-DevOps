package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtils {
    private ObjectUtils() {
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToJson(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
