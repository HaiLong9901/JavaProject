package com.javaservlet.controller;

import com.javaservlet.constants.Constants;
import com.javaservlet.models.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/userinfo"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletOutputStream out = response.getOutputStream();
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);

        if(userInfo == null) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/home");
        }

        out.println("<html>");
        out.println("<head><title>Session example</title></head>");

        out.println("<body>");

        out.println("<h3>User Info:</h3>");

        out.println("<p>User Name:" + userInfo.getUserName() + "</p>");
        out.println("<p>Age:" + userInfo.getUserAge() + "</p>");
        out.println("<p>Email:" + userInfo.getUserEmail() + "</p>");

        out.println("</body>");
        out.println("<html>");
    }
}
