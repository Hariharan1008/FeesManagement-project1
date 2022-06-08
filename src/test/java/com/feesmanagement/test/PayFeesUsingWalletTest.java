package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.logic.PayFeesUsingWallet;
import com.feesmanagement.logic.SubtractMoneyFromWallet;
import com.feesmanagement.logic.UpdateFeesAfterUsingWallet;
import com.feesmanagement.model.Wallet;

public class PayFeesUsingWalletTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your email");
		String email=sc.next();
		System.out.println("enter your wallet mobile number");
		long mobile=sc.nextLong();
		PayFeesUsingWallet pay=new PayFeesUsingWallet();
		Wallet wallet=pay.findFeesAndWalletBalance(email, mobile);
		System.out.println("Your pending fee is   : "+wallet.getPendingFees());
		System.out.println("your wallet balance is: "+wallet.getBalance());
		System.out.println("enter amount to pay");
		long amount=sc.nextLong();
		int amountValid=pay.amountVerifier(amount,wallet.getBalance(),wallet.getPendingFees());
		if(amountValid==0)
		{
			wallet.setAmount(amount);
			UpdateFeesAfterUsingWallet updatefees=new UpdateFeesAfterUsingWallet();
			updatefees.adminTableUpdation(amount);
			SubtractMoneyFromWallet subtract=new SubtractMoneyFromWallet();
			subtract.walletUpdatiorAfterPayment( mobile, amount);
		}
	}

}
