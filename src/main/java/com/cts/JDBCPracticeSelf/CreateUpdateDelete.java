package com.cts.JDBCPracticeSelf;

import java.sql.*;

public class CreateUpdateDelete {

	public static void main(String[] args) throws SQLException {
		/*
         * import packages
         * load and register driver
         * create connection
         * create statement
         * execute statement
         * close the connection
         */
		
		//Initialize url, uname & password
		String url="jdbc:mysql://localhost:3306/demo";
		String uname="root";
		String password="$Goswami990334";
		//String sql="insert into demo.student values(6,'Abir', 98.23)";
		String sqlUpdate="update demo.student set sname='Karan' where sid=5;";
		String sqlDelete="delete from demo.student where sid=6;";
		
		
		//Creating Connection
		Connection con=DriverManager.getConnection(url, uname, password);
		System.out.println("Connection is made");
		
		//Creating Statement
		Statement st =con.createStatement();
		
		st.execute(sqlUpdate);//new value is updated
		
		st.execute(sqlDelete);//delete value
		
		//Printing the table
		ResultSet rs= st.executeQuery("select * from demo.student");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+" - ");//1 represents column number
    		System.out.print(rs.getString(2)+" - ");
    		System.out.print(rs.getDouble(3)+"\n");
		}
		
		
		con.close();
		System.out.println("Connection is closed");
		

	}

}
