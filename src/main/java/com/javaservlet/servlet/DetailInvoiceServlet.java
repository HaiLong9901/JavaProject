package com.javaservlet.servlet;

import com.javaservlet.models.DetailedInvoice;
import com.javaservlet.models.Invoice;
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

@WebServlet(urlPatterns = {"/invoice/import/detail"})
public class DetailInvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DetailInvoiceServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String id = (String) request.getParameter("invoiceId");
        int invoiceId = 0;
        Invoice invoice = null;
        List<DetailedInvoice> list = null;
        try {
            invoiceId = Integer.parseInt(id);
            invoice = DBUtils.findInvoice(conn, invoiceId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/detailInvoiceView.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
