package com.feesmanagement.logic;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.feesmanagement.dao.FindWalletBalanceDao;
import com.feesmanagement.dao.UpdateWalletTransactionDao;
import com.feesmanagement.dao.WalletAndTransactionUpdatorDao;
import com.feesmanagement.model.Wallet;

public class SubtractMoneyFromWallet {
	public int walletUpdatiorAfterPayment(long mobile,long amount) throws ClassNotFoundException, SQLException
	{
		FindWalletBalanceDao findBalance=new FindWalletBalanceDao();
		long balance=findBalance.findWalletBalance(mobile);
		long updatedBalance=balance-amount;
		WalletAndTransactionUpdatorDao walletUpdate=new  WalletAndTransactionUpdatorDao();
		int completed=walletUpdate.walletUpdationAfterPayment(mobile, updatedBalance);
		if(completed==1)
		{
			UpdateWalletTransactionDao TransactionUpdate=new UpdateWalletTransactionDao();
			Wallet wallet=new Wallet();
			wallet.setAmount(amount);
			wallet.setMobile(mobile);
			wallet.setOperation("Debited");
			wallet.setDate(Date.valueOf(LocalDate.now()));
			int updated=TransactionUpdate.updateWalletTransaction(wallet);
			return updated;
		}
		return 0;
	}

}
