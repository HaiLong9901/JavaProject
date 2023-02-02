package com.javaservlet.servlet;

import com.javaservlet.models.Invoice;
import com.javaservlet.models.Product;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/invoice/import/add"})
public class CreateImportInvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CreateImportInvoiceServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        List<Product> productList = new ArrayList<Product>();
        String errorString = null;
        String account = MyUtils.getUserNameInCookie(request);
        UserAccount acc = null;
        try {
            productList = DBUtils.queryProduct(conn);
            acc = DBUtils.findUser(conn, account);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("productList", productList);
        request.setAttribute("account", acc.getFullName());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createImportInvoiceView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String count = (String) request.getParameter("count");
        String partner = (String) request.getParameter("partner");
        String account = MyUtils.getUserNameInCookie(request);
        UserAccount acc = null;
        String errorString = null;
        int aidi = 0;
        try {
            acc = DBUtils.findUser(conn, account);
            System.out.println("acc: " + acc.getUserId());
            Invoice invoice = new Invoice(Integer.toString(acc.getUserId()), 0, partner);
            aidi = DBUtils.insertInvoice(conn, invoice);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        System.out.println("aidi: " + aidi);
    }
}
