package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterValidationUsingDatabase {
	public static int emailValidator(String email) throws Exception
	{
		Connection connection ;
	    PreparedStatement statement;
	    ResultSet rs = null;
	    connection = ConnectionUtil.databaseConnection();
		String query = "SELECT user_Email FROM Fees_User WHERE user_Email=?";
		statement = connection.prepareStatement(query);
        statement.setString(1, email);  
        rs = statement.executeQuery();
        String mail=null;
		while(rs.next())
		{
		 mail=rs.getString("user_Email");
		}
		if(mail!=null)
		{
			throw new Exception("You are already an existing User!!!!,Please Login");
		}
		else
		{
			return 1;
		}
		
		
	}
	public static int mobileValidator(String mobile) throws Exception
	{
		Connection connection ;
	    PreparedStatement statement;
	    ResultSet rs = null;
	    connection = ConnectionUtil.databaseConnection();
	    String query = "SELECT User_Mobile FROM Fees_User WHERE User_Mobile=?";
	    statement = connection.prepareStatement(query);
        statement.setString(1, mobile);  
        rs = statement.executeQuery();
        String mob=null;
	    while(rs.next())
	    {
	        mob=rs.getString("User_Mobile");
	    }
	    if(mob!=null)
	    {
		   throw new Exception("You are already an existing User!!!!,Please Login");
	    }
	   else
	   {
		   return 1;
	   }
	}


}
