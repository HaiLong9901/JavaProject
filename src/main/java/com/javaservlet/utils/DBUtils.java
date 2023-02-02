package com.javaservlet.utils;

import com.javaservlet.models.DetailedInvoice;
import com.javaservlet.models.Invoice;
import com.javaservlet.models.Product;
import com.javaservlet.models.UserAccount;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static  List<UserAccount> queryUser(Connection conn) throws SQLException {
        String sql = "select userid,fullname, username, email, phone from useraccount where isactive=true";
        PreparedStatement prsm = conn.prepareStatement(sql);
        ResultSet rs = prsm.executeQuery();
        List<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            int userId = rs.getInt("userid");
            String userName = rs.getString(("username"));
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            UserAccount user = new UserAccount(userId, fullName, userName, email, phone);
            list.add(user);
        }
        return list;
    }
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
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setEmail(email);
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
            int userId = rs.getInt("userid");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUserId(userId);
            return user;
        }

        return null;
    }

    public static UserAccount findUser(Connection conn, int userId) throws  SQLException {
        String sql = "select * from useraccount where userid = ?";
        PreparedStatement prsm = conn.prepareStatement(sql);
        prsm.setInt(1, userId);
        ResultSet rs = prsm.executeQuery();
        while (rs.next()) {
            String useName = rs.getString("username");
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            UserAccount account = new UserAccount(userId, fullName, useName, email, phone);
            return account;
        }
        return null;
    }

    public static  void insertUser(Connection conn, UserAccount account) throws SQLException {
        String sql = "insert into useraccount(username, fullname, password, email, phone)\n" +
                "values (?,?,?,?,?)";
        PreparedStatement prsm = conn.prepareStatement(sql);
        prsm.setString(1, account.getUserName());
        prsm.setString(2, account.getFullName());
        prsm.setString(3, account.getPassword());
        prsm.setString(4, account.getEmail());
        prsm.setString(5, account.getPhone());

        prsm.executeUpdate();
    }

    public static void deleteAccount(Connection conn, String userId) throws SQLException {
        String sql = "update useraccount set isactive=false where userid=?";
        PreparedStatement prsm = conn.prepareStatement(sql);
        int id = 0;
        try {
            id = Integer.parseInt(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        prsm.setInt(1, id);
        prsm.executeUpdate();
    }

    public static void updateAccount(Connection conn, UserAccount account) throws SQLException {
        String sql = "update useraccount set username = ?, fullname = ?, email = ?, phone = ? where userid = ?";
        PreparedStatement prsm = conn.prepareStatement(sql);
        prsm.setString(1, account.getUserName());
        prsm.setString(2, account.getFullName());
        prsm.setString(3, account.getEmail());
        prsm.setString(4, account.getPhone());
        prsm.setInt(5, account.getUserId());

        prsm.executeUpdate();
    }

    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "select * from product\n" +
                "inner join brand on product.brand = brand.brandid\n" +
                "inner join genre on product.genre = genre.genreid\n" + " where isdelete=false ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            int code = rs.getInt("code");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String brand = rs.getString(12);
            String desc = rs.getString("product_desc");
            int originalPrice = rs.getInt("original_price");
            int quantity = rs.getInt("quantity");
            String genre = rs.getString(14);
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            product.setProduct_desc(desc);
            product.setBrand(brand);
            product.setOriginalPrice(originalPrice);
            product.setGenre(genre);
            product.setQuantity(quantity);
            list.add(product);
        }

        return list;
    }

    public static Product findProduct(Connection conn, int code) throws SQLException {
        String sql = "select * from product where code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, code);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String brand = rs.getString("brand");
            String desc = rs.getString("product_desc");
            String genre = rs.getString("genre");
            int originalPrice = rs.getInt("original_price");
            InputStream image = rs.getBinaryStream("image");
            Product product = new Product(name, price, brand, desc, genre, image, originalPrice);
            product.setCode(code);
            product.print();
            return product;
        }

        return null;
    }

    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = null;
        if (product.getImage() != null) {
            sql = "update product set name=?, price=?, brand=?, product_desc=?, genre=?, image=?, original_price=?   where code=?";
        }
        else sql = "update product set name=?, price=?, brand=?, product_desc=?, genre=?,original_price=?   where code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int brandId = 1;
        int genreId = 1;
        try {
            brandId = Integer.parseInt(product.getBrand());
            genreId = Integer.parseInt(product.getGenre());
        } catch (Exception e) {

        }
        pstm.setString(1, product.getName());
        pstm.setInt(2, product.getPrice());
        pstm.setInt(3, brandId);
        pstm.setString(4, product.getProduct_desc());
        pstm.setInt(5, genreId);
        if (product.getImage() != null) {
            pstm.setBinaryStream(6, product.getImage());
            pstm.setInt(7, product.getOriginalPrice());
            pstm.setInt(8, product.getCode());
        }
        else{
            pstm.setInt(6, product.getOriginalPrice());
            pstm.setInt(7, product.getCode());
        }
        pstm.executeUpdate();
    }

    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = null;
        if (product.getImage() == null) sql = "insert into product(name, price, brand, product_desc, genre, original_price) values(?,?,?,?,?,?)";
        else sql = "insert into product(name, price, brand, product_desc, genre, image, original_price) values(?,?,?,?,?,?,?)";
        int brandId = 1;
        int genreId = 1;
        try {
            brandId = Integer.parseInt(product.getBrand());
            genreId = Integer.parseInt(product.getGenre());
        } catch (Exception e) {

        }
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setInt(2, product.getPrice());
        pstm.setInt(3, brandId);
        pstm.setString(4, product.getProduct_desc());
        pstm.setInt(5, genreId);
        if (product.getImage() != null) {
            pstm.setBinaryStream(6, product.getImage());
            pstm.setInt(7, product.getOriginalPrice());
        }
        else pstm.setInt(6, product.getOriginalPrice());


        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "update product set isdelete = true where code=?";
        int productCode = 0;
        try {
            productCode = Integer.parseInt(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, productCode);
        pstm.executeUpdate();
    }

    //Invoice
    public static List<Invoice> queryImportInvoice(Connection conn) throws SQLException {
        String sql = "select * from invoice\n" + "inner join useraccount on invoice.account = useraccount.userid where isimport=true";
        PreparedStatement prsm = conn.prepareStatement(sql);
        ResultSet rs = prsm.executeQuery();
        List<Invoice> list = new ArrayList<Invoice>();
        while (rs.next()) {
            int invoiceId = rs.getInt("invoiceid");
            String createdAt = rs.getString("createdat");
            int amount = rs.getInt("amount");
            String partner = rs.getString("partner");
            String account = rs.getString("fullname");
            Invoice invoice = new Invoice(invoiceId, createdAt, account, amount, partner);
            list.add(invoice);
        }
        return list;
    }

    public static int insertInvoice(Connection conn, Invoice invoice) throws SQLException {
        String sql = "insert into invoice(account, partner, amount) values (?, ?, ?)";
        PreparedStatement prsm = conn.prepareStatement(sql);
        int accountId = 0;
        try {
            accountId = Integer.parseInt(invoice.getAccount());
        } catch (Exception e) {
            e.printStackTrace();
        }
        prsm.setInt(1, accountId);
        prsm.setString(2, invoice.getPartner());
        prsm.setInt(3, invoice.getAmount());

        prsm.executeUpdate();

        String querySql = "select * from invoice\n" +
                "order by createdat desc\n" +
                "limit 1";
        prsm = conn.prepareStatement(querySql);
        ResultSet rs = prsm.executeQuery();
        while (rs.next()) {
            return rs.getInt("invoiceid");
        }
        return 0;
    }

    public static void insertDetailedInvoice(Connection conn, DetailedInvoice detailedInvoice) throws SQLException {
//        String sql = ""
    }
}
