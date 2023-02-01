package com.javaservlet.servlet;

import com.javaservlet.constants.Constants;
import com.javaservlet.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        session.removeAttribute("loginedUser");
//        MyUtils.deleteUserCookie(response);
//        Cookie[] cookie = request.getCookies();
//        MyUtils.removeCookies(request, response);
//        Cookie cookie = new Cookie("ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE", "");
//        cookie.setMaxAge(0);
//        cookie.setPath("/");
//        cookie.setValue("");
//        response.addCookie(cookie);
        MyUtils.deleteUserCookie(response);

        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
