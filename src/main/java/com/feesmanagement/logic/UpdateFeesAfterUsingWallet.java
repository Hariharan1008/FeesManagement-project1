package com.feesmanagement.logic;

import com.feesmanagement.dao.FeesUpdationDao;
import com.feesmanagement.dao.TotalAndPaidFeesFinder;
import com.feesmanagement.model.FeesStructure;
import com.feesmanagement.model.Wallet;

public class UpdateFeesAfterUsingWallet {
	public void adminTableUpdation(long amount) throws Exception
	{
		FeesStructure feesStructure=TotalAndPaidFeesFinder.totalFeesFinder();
		long paidFees=Long.parseLong(feesStructure.getFeesPaid());
		long pendingFees=Long.parseLong(feesStructure.getFeesPending());
		paidFees=paidFees+amount;
		pendingFees=pendingFees-amount;
		feesStructure.setFeesPaid(Long.toString(paidFees));
		feesStructure.setFeesPending(Long.toString(pendingFees));
		feesStructure.setPayingAmount(Long.toString(amount));
		FeesUpdationDao.feesUpdation(feesStructure);
	}

}
