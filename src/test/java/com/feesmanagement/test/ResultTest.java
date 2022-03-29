package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.logic.ResultFinder;

public class ResultTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email");
		String email=sc.next();
		ResultFinder.findResult(email);
		
	}

}
