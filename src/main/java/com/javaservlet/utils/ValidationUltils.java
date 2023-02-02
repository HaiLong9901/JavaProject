package com.javaservlet.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUltils {
    public static boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }
}
