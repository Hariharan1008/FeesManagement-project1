package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateWalletDao{
	public int updateMyWallet(long mobile,long updatedBalance) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement=null;
		String query="update fees_wallet set balance=? where mobile_no=? ";
		statement=connection.prepareStatement(query);
		statement.setLong(1,updatedBalance);
		statement.setLong(2, mobile);
		int rows=statement.executeUpdate();
		return rows;
		
		
	}

}
