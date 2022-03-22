package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feesmanagement.model.Tickets;

public class FindTicketUsingIdDao {
	public static Tickets usingTicketId(int ticketId) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement=null;
		String qurey="select Queries,Ticket_Status,Created_On from Tickets where Ticket_Id=?";
		statement=connection.prepareStatement(qurey);
		statement.setInt(1, ticketId);
		ResultSet result=statement.executeQuery();
		String myQuery=null;
		Date date=null;
		Tickets ticket=null;
		String ticketStatus=null;
		if(result.next())
		{
			ticket=new Tickets();
			myQuery=result.getString("Queries");
			date=result.getDate("Created_On");
			ticketStatus=result.getString("Ticket_Status");
			ticket.setMyQuery(myQuery);
			ticket.setCreatedOn(date);
			ticket.setTicketStatus(ticketStatus);
		}
		return ticket;
	}

	
}
