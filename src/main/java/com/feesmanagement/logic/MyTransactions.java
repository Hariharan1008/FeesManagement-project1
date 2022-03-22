package com.feesmanagement.logic;

import java.sql.SQLException;
import java.util.List;

import com.feesmanagement.dao.MyTransactionDetailsDao;
import com.feesmanagement.model.Transaction;

public class MyTransactions {
	public static void allMyTransactions(String email) throws ClassNotFoundException, SQLException
	{
		List<Transaction> transactions=MyTransactionDetailsDao.findMyTransactionDetails(email);
		if(transactions!=null)
		{
			for (Transaction transaction : transactions) {
				System.out.println("Payment status :  Success!!");
				System.out.println("Paid amount    : " + transaction.getPaidAmount());
				System.out.println("Paid on        : " + transaction.getPaidOn());
				System.out.println();
			}
		}
		else
		{
			System.out.println("No transactions found");
		}
		
	}

}
