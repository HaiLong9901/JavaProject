package com.javaservlet.servlet;

import com.javaservlet.models.UserAccount;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.MyUtils;
import com.javaservlet.utils.ValidationUltils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet (urlPatterns = "/account/edit")
public class EditAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditAccountServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String userIdStr = (String) request.getParameter("userId");
        System.out.print("id: " + userIdStr);
        int userId = 0;
        try {
            userId = Integer.parseInt(userIdStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserAccount account = null;
        String errorString = null;
        try {
            account = DBUtils.findUser(conn, userId);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("acc", account);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editAccountView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String userIdStr = (String) request.getParameter("userId");
        System.out.println("doPost: " + userIdStr);
        int userId = 0;
        try {
            userId = Integer.parseInt(userIdStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userName = (String) request.getParameter("userName");
        String fullName = (String) request.getParameter("fullName");
        String email = (String) request.getParameter("email");
        String phone = (String) request.getParameter("phone");
        String dog = (String) request.getParameter("count");
        System.out.println("DOg: " + dog);
        UserAccount account = new UserAccount(userId, fullName, userName, email, phone);
        String errorString = null;

        try {
            DBUtils.updateAccount(conn, account);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (!ValidationUltils.validatePhone(phone)) errorString = "Số điện thoại phải bao gồm 10 chữ số";
        request.setAttribute("errorString", errorString);
        request.setAttribute("acc", account);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editAccountView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/account/list");
        }
    }
}
