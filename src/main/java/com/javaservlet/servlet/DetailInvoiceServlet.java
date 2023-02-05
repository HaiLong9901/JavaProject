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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/invoice/import/detail"})
public class DetailInvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DetailInvoiceServlet() {
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
        String id = (String) request.getParameter("invoiceId");
        int invoiceId = 0;
        Invoice invoice = null;
        List<DetailedInvoice> list = null;
        String accountName = null;
        List<Product> productList = new ArrayList<>();
        String errorString = null;
        try {
            invoiceId = Integer.parseInt(id);
            invoice = DBUtils.findInvoice(conn, invoiceId);
            list = DBUtils.queryDetailInvoice(conn, invoiceId);
            UserAccount acc = DBUtils.findUser(conn, Integer.parseInt(invoice.getAccount()));
            accountName = acc.getFullName();
            for (DetailedInvoice detailedInvoice : list) {
                Product product = DBUtils.findProduct(conn, detailedInvoice.getProductId());
                product.setQuantity(detailedInvoice.getQuantity());
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("accountName", accountName);
        request.setAttribute("productList", productList);
        request.setAttribute("invoice", invoice);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/detailInvoiceView.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
