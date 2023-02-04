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
@WebServlet(urlPatterns = {"/invoice/export/add"})
public class CreateExportInvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CreateExportInvoiceServlet() {
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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createExportInvoiceView.jsp");
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
            Invoice invoice = new Invoice(Integer.toString(acc.getUserId()), 0, partner, false);
            invoiceId = DBUtils.insertInvoice(conn, invoice);
            for (int i = 0; i < count; ++i) {
                System.out.println("in loop");
                int productId = 0;
                int quantity = 0;
                try {
                    productId = Integer.parseInt((String) request.getParameter("product" + i)) ;
                    quantity = Integer.parseInt((String) request.getParameter("quantity" + i)) ;
                } catch (Exception e) {
                    e.printStackTrace();
                    errorString = "Số lượng phải là số";
                }
                Product product = DBUtils.findProduct(conn, productId);
                if (product.getQuantity() < quantity) {
                    errorString = "Sản phẩm " + product.getName() + " còn " + product.getQuantity() + " không đủ để xuất " + quantity + " sản phẩm";
                    System.out.println(errorString);
                    break;
                }
                DetailedInvoice detailedInvoice = new DetailedInvoice(invoiceId, productId, quantity);
                DBUtils.insertDetailedInvoice(conn, detailedInvoice);
                DBUtils.updateProductQuantity(conn, productId, quantity*-1);
                int productAmount = product.getPrice() * quantity;
                System.out.println("price: " + productAmount);
                DBUtils.updateInvoiceAmount(conn, invoiceId, productAmount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null) {
            List<Product> productList = new ArrayList<Product>();
            try {
                productList = DBUtils.queryProduct(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("productList", productList);
            request.setAttribute("account", acc.getFullName());
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createExportInvoiceView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/invoice/export/detail?invoiceId=" + invoiceId);
        }
    }
}
