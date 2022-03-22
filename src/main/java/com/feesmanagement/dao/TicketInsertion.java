package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feesmanagement.model.Tickets;

public class TicketInsertion {
	public static void ticketInsertion(Tickets ticket,int ticketId) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement=null;
		String query="insert into Tickets(Ticket_Id,Email,Created_On,Ticket_Status,Queries)values(?,?,?,?,?)";
		statement=connection.prepareStatement(query);
		statement.setInt(1,ticketId);
		statement.setString(2, ticket.getEmail());
		statement.setDate(3, ticket.getCreatedOn());
		statement.setString(4, ticket.getTicketStatus());
		statement.setString(5, ticket.getMyQuery());
		int rows = statement.executeUpdate();
     }

}
