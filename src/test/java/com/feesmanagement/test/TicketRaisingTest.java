package com.feesmanagement.test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.feesmanagement.logic.TicketRaising;
import com.feesmanagement.model.Tickets;

public class TicketRaisingTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email");
		String email=sc.next();
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter your query");
		String query=sc1.nextLine();
		Date date=Date.valueOf(LocalDate.now());
		Tickets tickets=new Tickets();
		tickets.setMyQuery(query);
		tickets.setEmail(email);
		tickets.setCreatedOn(date);
		tickets.setTicketStatus("Pending");
		try
		{
		
		   TicketRaising.ticketValidation(tickets);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
