package com.feesmanagement.test;

import java.util.Scanner;

import com.feesmanagement.logic.FeesStructureLogic;

public class FeesStructureTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter year");
		int year=sc.nextInt();
		System.out.println("enter branch");
		String branch=sc.next();
		FeesStructureLogic.feesStructure(year,branch);
		

	}

}
