package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.logic.TransactionDetailsUsingId;

public class FindTransactionDetailsUsingIdTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your transaction id");
		int id=sc.nextInt();
		TransactionDetailsUsingId.transactionDetailsUsingId(id);

	}

}
