package com.feesmanagement.logic;

import com.feesmanagement.dao.TicketInsertion;
import com.feesmanagement.model.Tickets;

public class TicketRaising {
	static int ticketId=145312;
	public static void  ticketValidation(Tickets tickets) throws Exception
	{
		int emailValid=emailValidation(tickets.getEmail());
		int queryValid=queryValidation(tickets.getMyQuery());
		int ticketId=getTicketId();
		if(emailValid+queryValid==2)
		{
			TicketInsertion.ticketInsertion(tickets,ticketId);
		}
		System.out.println("Your query has been Registered");
		System.out.println("Sorry for the inconvenience we made.. ");
		System.out.println("please note your Ticket_Id : "+ticketId);
		System.out.println("your query will be resolved quickly..Thanking you ");
	}
	public static int emailValidation(String email) throws Exception
	{
		int valid=0;
		if(email.contains("@") && email.contains("."))
		{
			valid=1;
		}
		else
		{
			throw new Exception("Please enter a valid email");
		}
		return valid;
	}
	public static int queryValidation(String query) throws Exception
	{
		int valid=0;
		if(query==null || query.isEmpty())
		{
			throw new Exception("Query can not be null");
		}
		else
		{
			valid=1;
		}
		return valid;
	}
	public static int getTicketId()
	{
		ticketId++;
		int b = (int)(Math.random()*(5000-8000+1)+5000);
		return ticketId+b;
	}


}
