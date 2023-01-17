package com.javaservlet.controller;

import com.javaservlet.models.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreController {
    public static List<Genre> queryGenre(Connection conn) throws SQLException {
        String sql = "select * from public.genre";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Genre> list = new ArrayList<Genre>();
        while (rs.next()) {
            int genreid = rs.getInt("genreid");
            String name = rs.getString("name");
            Genre genre = new Genre(genreid, name);
            list.add(genre);
        }
        return list;
    }
}
