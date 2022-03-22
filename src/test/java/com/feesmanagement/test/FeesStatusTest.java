package com.feesmanagement.test;

import java.util.Scanner;

import com.feesmanagement.dao.FeesStatusDao;

public class FeesStatusTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your mail");
		String email=sc.next();
		FeesStatusDao.myFees(email);

	}

}
