package com.feesmanagement.logic;
import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.dao.FeesUpdationDao;
import com.feesmanagement.dao.TotalAndPaidFeesFinder;
import com.feesmanagement.model.FeesStructure;
public class PayFeesLogic {
	public static int otp=1234;
	public static int transactionId=1234567;
	public static int captcha=12345;
	static Scanner sc=new Scanner(System.in);
	public static void paymentMethod() throws Exception
	{
		FeesStructure feesStructure=TotalAndPaidFeesFinder.totalFeesFinder();
		String total=feesStructure.getTotalFees();
		String paid=feesStructure.getFeesPaid();
		if(Integer.parseInt(total)==Integer.parseInt(paid))
		{
			System.out.println("You already paid your fees fully"+total+""+paid);
		}
		else 
		{
			totalAmountCheck(feesStructure);
		}
		
	}
	public static int usingUpi() throws Exception
	{ 
		
		   System.out.println("Enter your upi id");
			String upiId=sc.next();
			if(upiId.endsWith("@ybl"))
			{
			    return 1;
			}
			else
			{
				System.out.println("Enter a valid upi Id");
				usingUpi();
				return 0;
			}
	}
	public static int getCaptcha()
	{
		captcha++;
		int b = (int)(Math.random()*(50000-80000+1)+50000);
		return captcha+b;
	}
	public static int getOtp()
	{
		otp++;
		int b = (int)(Math.random()*(5000-8000+1)+5000);  
		return otp+b;
	}
	public static int getTransactionId()
	{
		transactionId++;
		int b = (int)(Math.random()*(500000-800000+1)+500000);
		return transactionId+b;
	}
	public static int verification() throws Exception
	{
		int verificationCount=0;
		int actualCaptcha=getCaptcha();
		System.out.println(actualCaptcha);
		System.out.println("Enter the above number captcha");
		int userCaptcha=sc.nextInt();
		if(userCaptcha==actualCaptcha)
		{
			return 1;
		}
		else
		{
			verification();
			return 0;
		}
		
	}
	public static int otpVerification() throws Exception
	{
		
		int actualOtp=getOtp();
		System.out.println(actualOtp);
		System.out.println("Enter the above OTP");
		int userOtp=sc.nextInt();
		if(actualOtp==userOtp)
		{
			
			return 1;
		
		}
		else
		{
			otpVerification();
			return 0;
			
		}
		
	}
	public static void totalAmountCheck(FeesStructure fee) throws Exception
	{
		System.out.println("Enter the amount to pay");
		int amount=sc.nextInt();
		if(amount>Integer.parseInt(fee.getFeesPending()))
		{
			System.out.println("You already paid:"+fee.getFeesPaid());
			System.out.println("please pay only upto pending balance:"+fee.getFeesPending());
			totalAmountCheck(fee);
		}
		else
		{
			
			int paid=Integer.parseInt(fee.getFeesPaid())+amount;
			fee.setFeesPaid(Integer.toString(paid));
			int pending=Integer.parseInt(fee.getFeesPending())-amount;
			fee.setFeesPending(Integer.toString(pending));
			fee.setPayingAmount(Integer.toString(amount));
			int upiValid=usingUpi();
			int otpValid=otpVerification();
			if(upiValid+otpValid==2)
			{
				FeesUpdationDao.feesUpdation(fee);
			}
			
			
			
		}
		
		
		
		
		
	}
		
		

}
