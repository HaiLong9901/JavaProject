package com.javaservlet.controller;

import com.javaservlet.models.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandController {
    public static List<Brand> brandQuery(Connection conn) throws SQLException {
        String sql = "select * from brand";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Brand> list = new ArrayList<Brand>();
        while (rs.next()) {
            int brandId = rs.getInt("brandid");
            String name = rs.getString("name");
            Brand brand = new Brand(brandId, name);
            list.add(brand);
        }
        return list;
    }
}
