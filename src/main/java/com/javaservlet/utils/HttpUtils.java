package com.javaservlet.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {
    private String value;
    public HttpUtils(String value) {
        this.value = value;
    }
    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public <T> List<T> listModel(Class<T> tClass) {
        List<T> list = new ArrayList<T>();
        try {
            list.add(new ObjectMapper().readValue(value, tClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static HttpUtils of (BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpUtils(sb.toString());
    }
}
