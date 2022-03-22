package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FeesStatusDao {
	public static void myFees(String email) throws Exception
	{
		Connection connection;
	    PreparedStatement statement;
	    ResultSet rs = null;
	    connection = ConnectionUtil.databaseConnection();
		String query = "SELECT * FROM Fees_Admin WHERE Email=?";
		statement = connection.prepareStatement(query);
        statement.setString(1, email); 
        rs = statement.executeQuery();
		String totalFees=null;
		String feesPaid=null;
		String feesPending=null;
		if(rs.next())
		{
			totalFees=rs.getString("Total_Fees");
			feesPaid=rs.getString("Fees_paid");
			feesPending=rs.getString("Fees_Pending");
			 
		}
		   System.out.println("Total_Fees    = "+totalFees);
		   System.out.println("Fees_paid     = "+feesPaid);
		   System.out.println("Fees_Pending  = "+feesPending);
		   if(Integer.parseInt(feesPaid)==Integer.parseInt(totalFees))
		   {
			   System.out.println("You paid your fees fully!!...");
		   }
	}

}
