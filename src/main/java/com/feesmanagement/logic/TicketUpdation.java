package com.feesmanagement.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.feesmanagement.dao.MyTicketDetailsDao;
import com.feesmanagement.dao.TicketUpdationDao;
import com.feesmanagement.model.Tickets;

public class TicketUpdation {
	static Scanner sc=new Scanner(System.in);
	public static void getAllTickets() throws ClassNotFoundException, SQLException
	{
		List<Tickets> tickets=TicketUpdationDao.findAllTickets();
		if(tickets!=null)
		{
			for (Tickets ticket : tickets) {
				System.out.println("Ticket Id      : "+ ticket.getTicketId());
				System.out.println("Query          : "+ ticket.getMyQuery());
				System.out.println("Created on     : "+ ticket.getCreatedOn());
				System.out.println("Ticket status  : "+ ticket.getTicketStatus());
				System.out.println();
			}
			ticketUpdator();
		}
		else
		{
			System.out.println("No tickets found");
		}
	}
	public static void ticketUpdator() throws ClassNotFoundException, SQLException
	{
		System.out.println("Select the query to update");
		int id=sc.nextInt();
		System.out.println("Is that query resolved");
		System.out.println("1) Yes");
		System.out.println("2) No");
		int option=sc.nextInt();
		if(option==1)
		{
	       System.out.println("updating");
	       TicketUpdationDao.updateTicket(id);
	       System.out.println("Updated Successfully");  
		}
		System.out.println("1)Update more");
		int choice=sc.nextInt();
		if(choice==1)
		{
			ticketUpdator();
		}
		else
		{
			System.out.println();
		}
		
	}

}
