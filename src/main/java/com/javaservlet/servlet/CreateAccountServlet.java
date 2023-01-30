package com.javaservlet.servlet;

import com.javaservlet.models.UserAccount;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createAccountView.jsp");
            dispatcher.forward(request, response);
        }

        response.sendRedirect(request.getContextPath() + "/account/list");
    }
}
