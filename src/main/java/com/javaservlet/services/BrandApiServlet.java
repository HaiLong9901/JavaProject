package com.javaservlet.services;

import com.javaservlet.models.Brand;
import com.javaservlet.models.Genre;
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

@WebServlet(urlPatterns = {"/api/brands"})
public class BrandApiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        List<Brand> brands = HttpUtils.of(request.getReader()).listModel(Brand.class);
        try {
            brands = DBUtils.brandQuery(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mapper.writeValue(response.getOutputStream(), brands);
    }
}
