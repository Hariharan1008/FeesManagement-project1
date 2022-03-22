package com.feesmanagement.logic;

import java.sql.SQLException;

import com.feesmanagement.dao.TransactionDetailsUsingIdDao;
import com.feesmanagement.model.Transaction;

public class TransactionDetailsUsingId {
	public static void transactionDetailsUsingId(int id) throws ClassNotFoundException, SQLException
	{
		Transaction transaction=TransactionDetailsUsingIdDao.usingTransactionId(id);
		if(transaction!=null)
		{
			System.out.println("Payment status :  Success");
			System.out.println("Paid amount    : " + transaction.getPaidOn());
			System.out.println("Paid on        : "+transaction.getPaidAmount());
		}
		else
		{
			System.out.println("No transactions found");
		}
	}

}
