package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feesmanagement.model.Transaction;

public class TransactionDetailsUsingIdDao {
	public static Transaction usingTransactionId(int transactionId) throws SQLException, ClassNotFoundException
	{
		Connection connection = ConnectionUtil.databaseConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "SELECT Transaction_Id,Paid_Amount,Paid_On FROM Transaction_Details WHERE Transaction_Id=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, transactionId);
		result = statement.executeQuery();
		int id=0;
		String paid=null;
		Date date=null;
		Transaction transaction=null;
		if(result.next())
       {
			transaction=new Transaction();
			id=result.getInt("Transaction_Id");
    	    paid=result.getString("Paid_Amount");
    	    date=result.getDate("Paid_On");
    	    transaction.setTransactionId(id);
    	    transaction.setPaidAmount(paid);
    	    transaction.setPaidOn(date);
    	    
       }
		return transaction;
	}

}
