package com.javaservlet.servlet;

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
import java.util.List;

@WebServlet(urlPatterns = {"/invoice/export/list"})
public class ExportInvoiceListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ExportInvoiceListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        List<Invoice> list = null;
        String errorString = null;
        try {
            list = DBUtils.queryExportInvoice(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (list != null) {
            for (Invoice invoice:list) {
                invoice.print();
            }
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("invoiceList", list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/exportInvoiceListView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
