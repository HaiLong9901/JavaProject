package com.javaservlet.services;

import com.javaservlet.models.Product;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.HttpUtils;
import com.javaservlet.utils.MyUtils;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/api/product"})
public class ProductApiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String codeStr = (String) request.getParameter("code");
        String genreId = (String) request.getParameter("genreId");
        String brandId = (String) request.getParameter("brandId");
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int code = 0;
        if (codeStr != null) {
            Product product = HttpUtils.of(request.getReader()).toModel(Product.class);
            try {
                code = Integer.parseInt(codeStr);
                product = DBUtils.findProduct(conn, code);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mapper.writeValue(response.getOutputStream(), product);
        } else if (genreId != null) {
            List<Product> products = HttpUtils.of(request.getReader()).listModel(Product.class);
            int genre = 0;
            try {
                genre = Integer.parseInt(genreId);
                products = DBUtils.findProductByGenre(conn, genre);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mapper.writeValue(response.getOutputStream(), products);
        } else if (brandId != null) {
            List<Product> products = HttpUtils.of(request.getReader()).listModel(Product.class);
            int brand = 0;
            try {
                brand = Integer.parseInt(brandId);
                products = DBUtils.findProductByGenre(conn, brand);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mapper.writeValue(response.getOutputStream(), products);
        } else {
            List<Product> products = HttpUtils.of(request.getReader()).listModel(Product.class);
            try {
                products = DBUtils.queryProduct(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mapper.writeValue(response.getOutputStream(), products);
        }


    }
}
