package com.feesmanagement.logic;

import java.sql.SQLException;

import com.feesmanagement.dao.FindWalletBalanceDao;
import com.feesmanagement.dao.PendingFeesFinderDao;
import com.feesmanagement.model.Wallet;

public class PayFeesUsingWallet {
	public Wallet findFeesAndWalletBalance(String email,long mobile) throws ClassNotFoundException, SQLException
	{
		PendingFeesFinderDao total=new PendingFeesFinderDao();
		long pendingFees=total.findPendingFees(email);
		FindWalletBalanceDao walletBal=new FindWalletBalanceDao();
		long walletBalance=walletBal.findWalletBalance(mobile);
	//	System.out.println("your pending fee is        : "+pendingFees);
//		System.out.println("your walletBalance is      : "+walletBalance);
		Wallet wallet=new Wallet();
		wallet.setPendingFees(pendingFees);
		wallet.setBalance(walletBalance);
		return wallet;
	}
	public int amountVerifier(long amount,long balance,long pendingFees)
	{
		if(amount>balance)
		{
			return 1;
		}
		else if(amount>pendingFees)
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}
//	public int verifyAmountForTransfer(long mobile,long amount)
//	{
//		
//	}

}
