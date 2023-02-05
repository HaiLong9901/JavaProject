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

@WebServlet(urlPatterns = {"/account/create"})
public class CreateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateAccountServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        if (loginedUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        Connection conn = MyUtils.getStoredConnection(request);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createAccountView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String fullName = (String) request.getParameter("fullName");
        String userName = (String) request.getParameter("userName");
        String email = (String) request.getParameter("email");
        String phone = (String) request.getParameter("phone");
        String password = userName;

        UserAccount account = new UserAccount(userName, password, email, fullName, phone);
        String errorString = null;
//        if (fullName.length() == 0 || userName.length() == 0 || email.length() == 0 || phone.length() == 0) {
//            errorString = "Bạn phai điền đầy đủ các thông tin";
//        }
        if (!ValidationUltils.validateUserName(userName)) {
            errorString = "Tên tài khoản phải ít nhất 6 ký tự";
        }
        if (errorString == null) {
            try {
                DBUtils.insertUser(conn, account);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("acc", account);

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createAccountView.jsp");
            dispatcher.forward(request, response);
        }

        response.sendRedirect(request.getContextPath() + "/account/list");
    }
}
