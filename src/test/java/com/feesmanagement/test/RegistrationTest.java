package com.feesmanagement.test;

import java.util.Scanner;

import com.feesmanagement.logic.RegisterValidation;
import com.feesmanagement.model.Registration;

public class RegistrationTest {
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name");
		String name = sc.next();
		System.out.println("Enter your Username");
		String userName = sc.next();
		System.out.println("Enter your Mobile Number");
		String userMobileNumber = sc.next();
		System.out.println("Enter your age");
		Integer age = sc.nextInt();
		System.out.println("Enter your year of study (mention only 1,2,3,4)");
		Integer yearOfStudy=sc.nextInt();
		System.out.println("Enter your Branch (Ex: CSE ,EEE)");
		String branch=sc.next();
		System.out.println("Enter your Email");
		String userEmail=sc.next();
		System.out.println("Enter your Password");
		String userPassword = sc.next();
		Registration registration=new Registration();
		registration.setName(name);
		registration.setUserName(userName);
		registration.setUserMobileNumber(userMobileNumber);
		registration.setAge(age);
		registration.setYearOfStudy(yearOfStudy);
		registration.setBranch(branch);
		registration.setUserEmail(userEmail);
		registration.setUserPassword(userPassword);
		try
		{
		RegisterValidation.validatingRegistration(registration);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

}
