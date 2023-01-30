package com.javaservlet.servlet;

import com.javaservlet.models.Product;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/image"})
public class DisplayImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayImageServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        try {
            int code = 0;
            try {
                code = Integer.parseInt(request.getParameter("code"));
            } catch (Exception e) {

            }
            Product product = DBUtils.findProduct(conn, code);
            if (product == null) {
                response.sendRedirect(request.getContextPath() + "/product/productList");
                return;
            }
            response.setHeader("Content-Type", this.getServletContext().getMimeType(product.getName()));
            response.setHeader("Content-Length", String.valueOf(product.getImage()));
            response.setHeader("Content-Disposition", "inline;filename=\""+ product.getName() + "\"");
            response.getOutputStream().write(product.getImage().readAllBytes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
