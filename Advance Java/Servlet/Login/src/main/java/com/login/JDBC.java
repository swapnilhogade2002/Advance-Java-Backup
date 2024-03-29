package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/shree";  
        String uname = "root";
        String pass = "mysql@2002";
        String query = "select * from student"; 

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String name = rs.getString("namee");
            System.out.println(name);
        }

        rs.close();
        st.close();
        con.close();
    }
}
