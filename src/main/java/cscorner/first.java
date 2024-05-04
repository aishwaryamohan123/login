package cscorner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class first {

	public static void main(String[] args) throws SQLException {
	int id;
	String name;
	String email;
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "Rkv@2022");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from new_table");
	while(rs.next()){
	
	System.out.println(rs.getInt(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getString(3));}

			}

}


