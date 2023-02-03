package com.javaservlet.servlet;

import com.javaservlet.models.DetailedInvoice;
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
        String countStr = (String) request.getParameter("count");
        String partner = (String) request.getParameter("partner");
        String account = MyUtils.getUserNameInCookie(request);
        UserAccount acc = null;
        String errorString = null;
        int invoiceId = 0;
        int count = 0;
        try {
            count = Integer.parseInt(countStr);
            acc = DBUtils.findUser(conn, account);
            Invoice invoice = new Invoice(Integer.toString(acc.getUserId()), 0, partner);
            invoiceId = DBUtils.insertInvoice(conn, invoice);
            for (int i = 0; i < count; ++i) {
                int productId = Integer.parseInt((String) request.getParameter("product" + i)) ;
                int quantity = Integer.parseInt((String) request.getParameter("quantity" + i)) ;
                DetailedInvoice detailedInvoice = new DetailedInvoice(invoiceId, productId, quantity);
                DBUtils.insertDetailedInvoice(conn, detailedInvoice);
                DBUtils.updateProductQuantity(conn, productId, quantity);
                int productAmount = DBUtils.getProductOriginalPrice(conn, productId) * quantity;
                DBUtils.updateInvoiceAmount(conn, invoiceId, productAmount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createImportInvoiceView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/invoice/detail?invoiceId=" + invoiceId);
        }
    }
}
