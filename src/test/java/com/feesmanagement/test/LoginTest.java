package com.feesmanagement.test;

import java.util.Scanner;

import com.feesmanagement.dao.LoginValidationUsingDatabase;
import com.feesmanagement.model.Registration;

public class LoginTest {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("Enter Your Email");
		String email=sc.next();
		System.out.println("Enter Your Password");
		String password=sc.next();
		try
		{
		    String SessionMail=LoginValidationUsingDatabase.loginValidator(email,password);
		    if(SessionMail!=null)
		    {
		    	Registration.setSessionMail(SessionMail);
		    	//Index.features();
		    }
		}
		catch(Exception e)
		{
			System.out.println("Error!!"+e.getMessage());
		} 
	}

}
