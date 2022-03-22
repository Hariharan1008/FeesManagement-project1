package com.feesmanagement.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.feesmanagement.logic.TicketDetailsUsingId;

public class TicketDetailsUsingIdTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your ticket id");
		int ticketId=sc.nextInt();
		TicketDetailsUsingId.findUsingTicketId(ticketId);

	}

}
