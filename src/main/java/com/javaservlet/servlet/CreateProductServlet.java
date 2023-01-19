package com.javaservlet.servlet;

import com.javaservlet.controller.BrandController;
import com.javaservlet.controller.GenreController;
import com.javaservlet.models.Genre;
import com.javaservlet.models.Product;
import com.javaservlet.utils.DBUtils;
import com.javaservlet.utils.ExtractFile;
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
import java.util.ArrayList;
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
            genreList = GenreController.queryGenre(conn);
            brandList = BrandController.brandQuery(conn);
            for(Brand data : brandList) {
                System.out.println("Brandid: " + data.getBrandId() + " name: " + data.getName());
            }
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
//        List<InputStream> isList = new ArrayList<InputStream>();
//        isList.add(null);
//        System.out.println("len: " + request.);
        System.out.println("name: " + name);
        InputStream image = null;
        Part imageFile = request.getPart("image");
        if (imageFile!= null) {
            System.out.println(imageFile.getName());
            System.out.println(imageFile.getSize());
            System.out.println(imageFile.getContentType());
            image = imageFile.getInputStream();
        }
        try {
//            for (Part part : request.getParts()) {
//                String fileName = ExtractFile.extractFileName(part);
//                System.out.println("filename: " + fileName);
//                if (fileName != null && fileName.length() > 0) {
//                    InputStream is = part.getInputStream();
//                    isList.add(is);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        request.getPart();
        int price = 0;
        int originalPrice = 0;
        try {
            price = Integer.parseInt(priceStr);
            originalPrice = Integer.parseInt(originalPriceStr);
        } catch (Exception e) {

        }
        Product product = new Product(name, price, brand, productdesc, genre, image , originalPrice);
        System.out.println("na: "+ product.getName());
        String errorString =null;
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
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/product/productList");
        }
    }
}
