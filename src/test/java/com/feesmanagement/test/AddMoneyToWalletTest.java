package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.logic.AddMoneyToWallet;

public class AddMoneyToWalletTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter mobile no");
		long mobile=sc.nextLong();
		System.out.println("enter amount");
		long balance=sc.nextLong();
		AddMoneyToWallet add=new AddMoneyToWallet();
		int completed=add.addMoney(mobile, balance);
		if(completed==1)
		{
			System.out.println("money add Successfully");
		}
		else
		{
			System.out.println("money not added");
		}

	}

}
