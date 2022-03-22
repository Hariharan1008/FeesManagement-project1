package com.feesmanagement.model;

import java.sql.Date;

public class Tickets {
	private String myQuery;
	private Date createdOn;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMyQuery() {
		return myQuery;
	}
	public void setMyQuery(String ticket) {
		this.myQuery = ticket;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date date) {
		this.createdOn = date;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	private String ticketStatus;
	

}
