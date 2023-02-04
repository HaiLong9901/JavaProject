package com.javaservlet.servlet;

import com.javaservlet.models.Genre;
import com.javaservlet.models.Product;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.MyUtils;
import com.javaservlet.models.Brand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/product/createProduct"})
@MultipartConfig(maxFileSize = 16177215)
public class CreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Genre> genreList = null;
        List<Brand> brandList = null;

        try {
            genreList = DBUtils.queryGenre(conn);
            brandList = DBUtils.brandQuery(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("genreList", genreList);
        request.setAttribute("brandList", brandList);
        request.setAttribute("errorString", errorString);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection conn = MyUtils.getStoredConnection(request);
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        String originalPriceStr = (String) request.getParameter("originalPrice");
        String genre = (String) request.getParameter("genre");
        String brand = (String) request.getParameter("brand");
        String productdesc = (String) request.getParameter("desc");
        InputStream image = null;
        Part imageFile = request.getPart("image");
        if (imageFile!= null) {
            System.out.println(imageFile.getName());
            System.out.println(imageFile.getSize());
            System.out.println(imageFile.getContentType());
            if (imageFile.getSize() == 0) image = null;
            else image = imageFile.getInputStream();
        }

        int price = 0;
        int originalPrice = 0;
        String errorString =null;
        try {
            price = Integer.parseInt(priceStr);
            originalPrice = Integer.parseInt(originalPriceStr);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = "Giá bán và giá gốc phải là 1 số";
        }
        Product product = new Product(name, price, brand, productdesc, genre, image , originalPrice);

        if(errorString == null) {
            try {
                DBUtils.insertProduct(conn, product);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        if (errorString != null) {
            List<Genre> genreList = null;
            List<Brand> brandList = null;

            try {
                genreList = DBUtils.queryGenre(conn);
                brandList = DBUtils.brandQuery(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("genreList", genreList);
            request.setAttribute("brandList", brandList);
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/product/productList");
        }
    }
}
