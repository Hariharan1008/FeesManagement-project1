package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.feesmanagement.model.Tickets;

public class MyTicketDetailsDao {
	public static List<Tickets> findAllTickets(String email) throws ClassNotFoundException, SQLException
	{
		List<Tickets> list=new ArrayList<Tickets>();
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement;
		ResultSet result=null;
		String query="SELECT * FROM my_ticket_using_email where email=?";
		statement=connection.prepareStatement(query);
		statement.setString(1, email);
		result=statement.executeQuery();
		Tickets ticket=null;
		String myQuery=null;
		Date date=null;
		String status=null;
		String name=null;
		while(result.next())
		{
			ticket=new Tickets();
			myQuery=result.getString("Queries");
			date=result.getDate("Created_On");
			status=result.getString("Ticket_Status");
			name=result.getString("Name");
			ticket.setName(name);
			ticket.setMyQuery(myQuery);
			ticket.setCreatedOn(date);
			ticket.setTicketStatus(status);
			list.add(ticket);
		}
		
		return list;
	}

}
