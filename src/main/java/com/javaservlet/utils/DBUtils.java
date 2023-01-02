package com.javaservlet.utils;

import com.javaservlet.models.Product;
import com.javaservlet.models.UserAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
        String sql = "select * from account where user_name=? and user_password=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if(rs.next()) {
            boolean gender = rs.getBoolean("user_genre");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender?UserAccount.GENDER_MALE:UserAccount.GENDER_FEMALE);
            return user;
        }

        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
        String sql = "select * from account where user_name=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();

        if(rs.next()) {
            boolean gender = rs.getBoolean("user_genre");
            String password = rs.getString("user_password");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender?UserAccount.GENDER_MALE:UserAccount.GENDER_FEMALE);
            return user;
        }

        return null;
    }

    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "select * from public.products ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("product_code");
            String name = rs.getString("product_name");
            Float price = rs.getFloat("product_price");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);
        }

        return list;
    }

    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "select * from public.products where product_code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String name = rs.getString("product_name");
            Float price = rs.getFloat("product_price");
            Product product = new Product(code, name, price);
            return product;
        }

        return null;
    }

    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "update public.products set product_name=?, product_price=? where product_code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();
    }

    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "insert into public.products(product_code, product_name, product_price) values(?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, Product product) throws SQLException {
        String sql = "delete from public.products where product_code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getCode());
        pstm.executeUpdate();
    }
}
