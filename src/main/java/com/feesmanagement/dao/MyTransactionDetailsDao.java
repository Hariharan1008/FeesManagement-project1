package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.feesmanagement.model.Transaction;

public class MyTransactionDetailsDao {
	public static List<Transaction> findMyTransactionDetails(String email) throws SQLException, ClassNotFoundException
	{
		List<Transaction> list=new ArrayList<Transaction>();
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement;
		ResultSet result=null;
		String query="select Paid_Amount,Paid_On from Transaction_Details where email=?";
		statement=connection.prepareStatement(query);
		statement.setString(1, email);
		result=statement.executeQuery();
		Transaction transaction=null;
		String paid=null;
		Date date=null;
		while(result.next())
		{
			transaction=new Transaction();
			paid=result.getString("Paid_Amount");
			date=result.getDate("Paid_On");
			transaction.setPaidAmount(paid);
			transaction.setPaidOn(date);
			list.add(transaction);
		}
		
		return list;
		
	}

}
