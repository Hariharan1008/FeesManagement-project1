package com.feesmanagement.logic;
import java.sql.SQLException;
import com.feesmanagement.dao.FindTicketUsingIdDao;
import com.feesmanagement.model.Tickets;

public class TicketDetailsUsingId {
	public static void findUsingTicketId(int ticketId) throws ClassNotFoundException, SQLException
	{
		Tickets tickets=FindTicketUsingIdDao.usingTicketId(ticketId);
		if(tickets!=null)
		{
			
			System.out.println("Query           : " + tickets.getMyQuery());
			System.out.println("Raised by       : " + tickets.getName() );
			System.out.println("Created on      : " + tickets.getCreatedOn());
			System.out.println("Query Status    : " + tickets.getTicketStatus());
		}
		else
		{
			System.out.println("No records found");
		}
		
	}

}
