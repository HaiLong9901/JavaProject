package com.javaservlet.utils;

import com.javaservlet.models.UserAccount;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class MyUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    public static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }

    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }

    public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static UserAccount getLoginedUser(HttpSession session) {
        UserAccount user = (UserAccount) session.getAttribute("loginedUser");
        return user;
    }

    public static void storeUserInCookie(HttpServletResponse response, UserAccount userAccount) {
        System.out.println("Store user in cookie");
        Cookie cookie = new Cookie(ATT_NAME_USER_NAME, userAccount.getUserName());
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for(Cookie cookie:cookies) {
                if(ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void removeCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie:cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                cookie.setValue("");
                response.addCookie(cookie);
            }
        }
    }

    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(ATT_NAME_USER_NAME, null);
        Cookie cookie1 = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie1.setMaxAge(0);
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }
}
