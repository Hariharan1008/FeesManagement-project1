package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.logic.FindAllMyTickets;

public class MyTicketDetailsTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email");
		String email=sc.next();
		FindAllMyTickets.getAllMyTickets(email);
	}

}
