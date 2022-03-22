package com.feesmanagement.logic;

import java.sql.SQLException;
import java.util.List;

import com.feesmanagement.dao.MyTicketDetailsDao;
import com.feesmanagement.dao.MyTransactionDetailsDao;
import com.feesmanagement.model.Tickets;
import com.feesmanagement.model.Transaction;

public class FindAllMyTickets {
	public static void getAllMyTickets(String email) throws ClassNotFoundException, SQLException
	{
		List<Tickets> tickets=MyTicketDetailsDao.findAllTickets(email);
		if(tickets!=null)
		{
			for (Tickets ticket : tickets) {
				System.out.println("Your Query     : "+ ticket.getMyQuery());
				System.out.println("Created on     : "+ ticket.getCreatedOn());
				System.out.println("Ticket status  : "+ ticket.getTicketStatus());
				System.out.println();
			}
		}
		else
		{
			System.out.println("No tickets found");
		}
	}

}
