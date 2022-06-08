package com.feesmanagement.test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.feesmanagement.dao.ProductTransactionDao;
import com.feesmanagement.dao.UpdateWalletPointsDao;
import com.feesmanagement.dao.WalletLoginValidationDao;
import com.feesmanagement.logic.BuyProducts;
import com.feesmanagement.logic.VerifyWalletPointsAndUpdate;
import com.feesmanagement.model.ProductTransaction;

public class BuyProductsTest {
   public static void main(String[] args) throws ClassNotFoundException, SQLException
   {
	   Scanner sc=new Scanner(System.in);
	   BuyProducts.getAllProducts();
	   
	   VerifyWalletPointsAndUpdate points=new VerifyWalletPointsAndUpdate();
	   System.out.println("enter product");
	   int productId=sc.nextInt();
	   System.out.println("enter mobile");
	   long mobile=sc.nextLong();
	   int verified=points.verifyPoints(productId,mobile);
	   if(verified==1)
	   {
		   System.out.println("enter tpin");
		   int tPin=sc.nextInt();
		   WalletLoginValidationDao login=new WalletLoginValidationDao();
		   int validCredential=login.validateWalletlogin(mobile, tPin);
		   if(validCredential==1)
		   {
			   VerifyWalletPointsAndUpdate updatePoints=new VerifyWalletPointsAndUpdate();
			   int updated=updatePoints.updateWalletPoints(productId, mobile);
			   if(updated==1)
			   {
				   ProductTransaction transaction=new ProductTransaction();
				   transaction.setProductId(productId);
				   transaction.setMobile(mobile);
				   transaction.setPurchasedOn(Date.valueOf(LocalDate.now()));
				   ProductTransactionDao updateTransaction=new ProductTransactionDao();
				   int completed=updateTransaction.updateProductTransaction(transaction);
				   if(completed==1)
				   {
					   System.out.println("Successfully Purchased");
				   }
			   }
			   else
			   {
				   System.out.println("Got some errors");
			   }
		   }
		   else
		   {
			   System.out.println("invalid Credentials");
		   }
	   }
	   else
	   {
		   System.out.println("insufficient wallet points");
	   }
   }

}
