package com.feesmanagement.logic;

import java.util.Scanner;

import com.feesmanagement.dao.RegisterInsertion;
import com.feesmanagement.dao.RegisterValidationUsingDatabase;
import com.feesmanagement.model.Registration;
public class RegisterValidation {
	public static void validatingRegistration(Registration registration)throws Exception
	{
		int isNameValid=nameValidation(registration.getName());
		int isUserNameValid=userNameValidation(registration.getUserName());
		int isMobileValid=userMobileNumberValidation(registration.getUserMobileNumber());
		int isAgeValid=userAgeValidation(registration.getAge());
		int isEmailValid=userEmailValidation(registration.getUserEmail());
		int isPasswordValid=userPasswordValidation(registration.getUserPassword());
		if(isNameValid+isUserNameValid+isMobileValid+isAgeValid+isEmailValid+isPasswordValid==6)
		{
			System.out.println("Welcome");
			RegisterInsertion.insertUser(registration);
		    registration.setSessionMail(registration.getUserEmail());
		    
		     
			
		}
		else
		{
			throw new Exception("Please Re-Enter Your Details");
		}
	}
	public static int nameValidation(String Name) throws Exception
	{
		if(Name!=null)
		{
			return 1;
		}
		else
		{
			throw new Exception("Enter a valid Name");
		}
	}
	public static int userNameValidation(String userName)
	{
		return 1;
	}
	public static int userMobileNumberValidation(String mobileNumber) throws Exception
	{
		int result=0;
		char[] mobile=mobileNumber.toCharArray();
		int count=0;
		if(mobile.length>10 || mobile.length<10)
		{
			throw new Exception("Mobile Number Must Be 10 Digits Long");
		}
		else
		{
			count++;
		}
		for(char i:mobile)
		{
			if(Character.isAlphabetic(i))
			{
				throw new Exception("Enter only Numeric values");
			}
			else
			{
				count++;
			}
		}
		if(count==11)
		{
			result=RegisterValidationUsingDatabase.mobileValidator(mobileNumber);
			if(result==1)
			{
				return 1;
				
			}
			
		}
		else
		{
			throw new Exception("Please Enter a Valid Mobile Number");
		}
		return result;
		
	}
	public static int userAgeValidation(int age)throws Exception
	{
		if(age<0 || age>100)
		{
			throw new Exception("Enter a valid age");
		}
		else
		{
			return 1;
		}
	}
	public static int userEmailValidation(String email)throws Exception
	{
		int result=0;
		if(email.contains("@"))
		{
		    result=RegisterValidationUsingDatabase.emailValidator(email);
			if(result==1)
			{
				return 1;
			}
		}
		else
		{
			throw new Exception("Enter a valid Email address");

		}
		return result;
	}
	public static int userPasswordValidation(String password)throws Exception
	{
		if(password.length()<8)
		{
			throw new Exception("Password must be 8 characters long");
		}
		else
		{
			return 1;
		}
	}




}
