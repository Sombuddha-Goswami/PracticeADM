package com.cts.JDBCPracticeSelf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection_ReadData
{
    public static void main( String[] args ) throws SQLException
    {
        /*
         * import packages
         * load and register driver
         * create connection
         * create statement
         * execute statement
         * close the connection
         */
    	
    	
    	String url="jdbc:mysql://localhost:3306/demo";
    	String uname="root";
    	String password="$Goswami990334";
    	//String sql="select sname as Name, marks from demo.student where sid=3";
    	String sql="select * from demo.student";
    	//Creating connection with db
    	Connection con=DriverManager.getConnection(url,uname,password);
    	
    	//Logger to check for the connection or error
    	System.out.println("Connection is made");
    	
    	//Create Statement
    	Statement st=con.createStatement();
    	
    	//Execute statement
    	//execute statement use to change something in the table 
    	//but executeQuery only fetch data like we need for select statement
    	ResultSet rs=st.executeQuery(sql); 
    	//ResultSet is an interface which by default stores the return value from the query
    	// so creating an object reference for that interface
    	
    /*	
    	System.out.println(rs.next());//rs.next executes the query and checks whether there is a next row or not    	
    	
    
    	//Printing only one name
    	//If we dont use rs.next() before using getString() then it will pass an error as 
    	//By default the query cursor points a row above the 1st row
    	String name=rs.getString("Name");//Getting the name 
    	System.out.println(name);
    	
    */
    	
    	
    	
    	//Printing all data table
    	while(rs.next()) //rs.next not only returns whether there is nxt row or not but also moves cursor to next row
    	{
    		System.out.print(rs.getInt(1)+" - ");//1 represents column number
    		System.out.print(rs.getString(2)+" - ");
    		System.out.print(rs.getDouble(3)+"\n");
    		
    	}
    	
    	con.close();//closing the connection
    	System.out.println("Connection is closed\n\n");
    	System.out.println("--added one line");
    	
    	
    	
    	
    }
}
