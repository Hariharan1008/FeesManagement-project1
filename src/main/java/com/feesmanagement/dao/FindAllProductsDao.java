package com.feesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.feesmanagement.model.Products;

public class FindAllProductsDao {
	public List<Products> getAllProducts() throws ClassNotFoundException, SQLException
	{
		List<Products> products=new ArrayList<Products>();
		Connection connection=ConnectionUtil.databaseConnection();
		PreparedStatement statement=null;
		ResultSet result=null;
		String query="select id,name,price,image,wallet_points from wallet_products";
		statement=connection.prepareStatement(query);
		result=statement.executeQuery();
		int id=0;
		String name=null;
		long price=0;
		String image=null;
		int walletPoints=0;
		Products product=null;
		while(result.next())
		{
			id=result.getInt("id");
			name=result.getString("name");
			price=result.getLong("price");
			image=result.getString("image");
			walletPoints=result.getInt("wallet_points");
			product=new Products();
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setImageUrl(image);
			product.setWalletpoints(walletPoints);
			products.add(product);
		}
		return products;
	}

}
