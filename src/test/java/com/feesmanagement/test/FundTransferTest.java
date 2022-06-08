package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.dao.FindWalletBalanceDao;
import com.feesmanagement.dao.FindWalletUserUsingMobile;
import com.feesmanagement.logic.UpdateFundTransaction;
import com.feesmanagement.model.FundTransfer;



public class FundTransferTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stubScanner sc=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		long senderMobile=sc.nextLong();
		long receiverMobile=sc.nextLong();
		long amount=sc.nextLong();;
		String message="";
		FindWalletUserUsingMobile findName=new FindWalletUserUsingMobile();
		String userName=findName.findUser(receiverMobile);
		long senderBalance=0;
		long receiverBalance=0;
		if(userName!=null)
		{
			System.out.println(userName);
			FindWalletBalanceDao findBalance=new FindWalletBalanceDao();
			senderBalance=findBalance.findWalletBalance(senderMobile);
			receiverBalance=findBalance.findWalletBalance(receiverMobile);
			if(amount<=senderBalance)
			{
				FundTransfer transfer=new FundTransfer();
				transfer.setAmount(amount);
				transfer.setSenderMobile(senderMobile);
				transfer.setReceiverMobile(receiverMobile);
				transfer.setSenderBalance(senderBalance);
				transfer.setReceiverBalance(receiverBalance);
				UpdateFundTransaction fund=new UpdateFundTransaction();
				fund.updateWallet(transfer);
						
			}
		}
		else
		{
			System.out.println("no user");
		}
		
		
	
			

	}

}
