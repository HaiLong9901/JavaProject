package com.javaservlet.utils;

import com.javaservlet.models.Product;
import com.javaservlet.models.UserAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
        String sql = "select * from useraccount where username=? and password=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if(rs.next()) {
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            Blob image = rs.getBlob("image");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setImage(image);
            user.setPhone(phone);
            return user;
        }

        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
        String sql = "select * from useraccount where username=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();

        if(rs.next()) {
            String password = rs.getString("password");
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            Blob image = rs.getBlob("image");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setImage(image);
            return user;
        }

        return null;
    }

    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "select * from product\n" +
                "inner join brand on product.brand = brand.brandid\n" +
                "inner join genre on product.genre = genre.genreid";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("code");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String brand = rs.getString(10);
            String desc = rs.getString("product_desc");
            int originalPrice = rs.getInt("original_price");
            Blob image = rs.getBlob("image");
            String genre = rs.getString(12);
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            product.setProduct_desc(desc);
            product.setBrand(brand);
            product.setImage(image);
            product.setOriginalPrice(originalPrice);
            product.setGenre(genre);
            System.out.println(product.getOriginalPrice());
            list.add(product);
        }

        return list;
    }

    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "select * from product where code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String branch = rs.getString("branch");
            String desc = rs.getString("product_desc");
            String genre = rs.getString("genre");
            int originalPrice = rs.getInt("original_price");
            Blob image = rs.getBlob("image");
            Product product = new Product(code, name, price, branch, desc, genre, image, originalPrice);
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
        String sql = "insert into public.products(name, price, branch, product_desc) values(?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setInt(2, product.getPrice());
        pstm.setString(3, product.getBrand());
        pstm.setString(4, product.getProduct_desc());
        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, Product product) throws SQLException {
        String sql = "delete from public.products where code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getCode());
        pstm.executeUpdate();
    }
}
