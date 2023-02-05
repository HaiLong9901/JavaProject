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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/account/myacc"})
public class MyAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyAccountServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        if (loginedUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        Connection conn = MyUtils.getStoredConnection(request);
        String account = MyUtils.getUserNameInCookie(request);
        UserAccount acc = null;
        String errorString = null;
        try {
            acc = DBUtils.findUser(conn, account);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("acc", acc);
        request.setAttribute("errorString", errorString);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/myAccountView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String account = MyUtils.getUserNameInCookie(request);
        String fullName = (String) request.getParameter("fullName");
        String phone = (String) request.getParameter("phone");
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String confirm = (String) request.getParameter("confirm");
        String errorString = null;
        UserAccount acc = null;
        try {
            acc = DBUtils.findUser(conn, account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!ValidationUltils.validatePhone(phone)) {
            errorString = "Số điện thoại phải gồm 10 chữ số";
        } else if (!ValidationUltils.validatePassword(password)) {
            errorString = "Mật khẩu phải ít nhất 6 kí tự";
        } else if (!confirm.equals(password)) {
            errorString = "Xác nhận mật khẩu không khớp";
        } else {
            try {
                acc.setPhone(phone);
                acc.setEmail(email);
                acc.setFullName(fullName);
                acc.setPassword(password);
                DBUtils.updateAccountWithPassword(conn, acc);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("acc", acc);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/myAccountView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/account/list");
        }

    }
}
