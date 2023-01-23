package com.javaservlet.servlet;

import com.javaservlet.controller.BrandController;
import com.javaservlet.controller.GenreController;
import com.javaservlet.models.Brand;
import com.javaservlet.models.Genre;
import com.javaservlet.models.Product;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/product/editProduct"})
@MultipartConfig(maxFileSize = 16177215)
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Connection conn = MyUtils.getStoredConnection(request);

//        int code = Integer.parseInt(request.getParameter("code")) ;
//        Product product = null;
//        String errorString = null;
//        List<Genre> genres = null;
//        List<Brand> brandList = null;
//        try {
//            genres = GenreController.queryGenre(conn);
//            brandList = BrandController.brandQuery(conn);
//            product = DBUtils.findProduct(conn, code);
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorString = e.getMessage();
//        }
//
//        if (errorString == null && product == null) {
//            response.sendRedirect(request.getServletPath() + "product/productList");
//            return;
//        }
//        request.setAttribute("genres", genres);
//        request.setAttribute("brandList", brandList);
//        request.setAttribute("errorString", errorString);
//        request.setAttribute("product", product);
//
//        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
//        dispatcher.forward(request, response);

        Connection conn = MyUtils.getStoredConnection(request);
        int code = Integer.parseInt(request.getParameter("code")) ;
        String errorString = null;
        Product product = null;
        List<Genre> genreList = null;
        List<Brand> brandList = null;
        try {
            genreList = GenreController.queryGenre(conn);
            brandList = BrandController.brandQuery(conn);
            product = DBUtils.findProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
//        String hello = "hello";
//        List<String> list = new ArrayList<String>();
//        list.add("hello");
//        list.add("Hi");
//        list.add("OK");
//        list.add("Good bye");
//        request.setAttribute("list", list);
        request.setAttribute("genreList", genreList);
        request.setAttribute("brandList", brandList);
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
//        request.setAttribute("hello", hello);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int code = Integer.parseInt(request.getParameter("code"));
        String name = (String) request.getParameter("name");
        String genre = (String) request.getParameter("genre");
        String brand = (String) request.getParameter("brand");
        String desc = (String) request.getParameter("product_desc");
        String priceString = (String) request.getParameter("price");
        String originalPriceString = (String) request.getParameter("originalPrice");
        int price = 0;
        int originalPrice = 0;
        try {
            price = Integer.parseInt(request.getParameter("price"));
            originalPrice = Integer.parseInt(request.getParameter("originalPrice"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Product product = new Product(name, price, brand, desc, genre, originalPrice);
        String errorString = null;

        try {
            DBUtils.updateProduct(conn, product);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/product/productList");
        }

    }
}
