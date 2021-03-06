package com.feesmanagement.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.feesmanagement.logic.HostelCheck;
import com.feesmanagement.model.Registration;

public class RegisterInsertion {
	public static void insertUser(Registration registration ) throws Exception 
	{
		int hostel=HostelCheck.hostelCheck();
		String hostelOrDayScholar=null;
		String bus=null;
		if(hostel==1)
		{
			 hostelOrDayScholar="H";
			 bus="No";
		}
		else if(hostel==2)
		{
			 hostelOrDayScholar="D";
			 bus="No";
		}
		else if(hostel==3)
		{
			 hostelOrDayScholar="D";
			 bus="Yes";
		}
		Connection connection ;
	    PreparedStatement statement;
	    connection = ConnectionUtil.databaseConnection();
		String query1="insert into Fees_User(name,User_Name,User_Mobile,User_Age,user_Email,User_Password,H_or_D,Bus,Pursuing_Year,User_Dept)values(?,?,?,?,?,?,?,?,?,?)";
		statement = connection.prepareStatement(query1);
        statement.setString(1, registration.getName());
        statement.setString(2, registration.getUserName());
        statement.setString(3, registration.getUserMobileNumber());
        statement.setInt(4, registration.getAge());
        statement.setString(5, registration.getUserEmail());
        statement.setString(6, registration.getUserPassword());
        statement.setString(7, hostelOrDayScholar);
        statement.setString(8, bus);
        statement.setInt(9, registration.getYearOfStudy());
        statement.setString(10, registration.getBranch());
        int rows = statement.executeUpdate();
       // System.out.println("No of rows inserted:" + rows);
	
	}
}

