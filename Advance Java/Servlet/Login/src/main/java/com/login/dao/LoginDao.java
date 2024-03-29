package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	String sql ="select * from user where email=? and pass=?";

	public boolean check(String email, String pass) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shree", "root", "mysql@2002");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;

	}

}
