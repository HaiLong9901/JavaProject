package com.javaservlet.servlet;

import com.javaservlet.controller.BrandController;
import com.javaservlet.controller.GenreController;
import com.javaservlet.models.Genre;
import com.javaservlet.utils.MyUtils;
import com.javaservlet.models.Brand;

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

@WebServlet(urlPatterns = {"/product/createProduct"})
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
            brandList = BrandController.branchQuery(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("genreList", genreList);
        request.setAttribute("branchList", brandList);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection conn = MyUtils.getStoredConnection(request);
        String name = (String) request.getParameter("name");
        String price = (String) request.getParameter("price");
        String originalPrice = (String) request.getParameter("originalPrice");
        String genre = (String) request.getParameter("genre");
        String brand = (String) request.getParameter("brand");
    }
}
