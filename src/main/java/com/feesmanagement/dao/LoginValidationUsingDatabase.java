package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginValidationUsingDatabase {
	public static String loginValidator(String email,String password) throws Exception
	{
		Connection connection ;
	    PreparedStatement statement;
	    ResultSet rs = null;
	    connection = ConnectionUtil.databaseConnection();
		String query = "SELECT user_Email,User_Password FROM Fees_User WHERE user_Email=?";
		statement = connection.prepareStatement(query);
        statement.setString(1, email);  
        rs = statement.executeQuery();
        String mail=null;
        String Password=null;
		while(rs.next())
		{
		 mail=rs.getString("user_Email");
		 Password=rs.getString("User_Password");
		}
		if(mail==null)
		{
			throw new Exception("No Records Found");
		}
		else if(Password.equals(password))
		{
			System.out.println("Success!!!..Logging you in..");
			return mail;
		}
		else
		{
			throw new Exception("Invalid Credentials");
		}
	}


}
