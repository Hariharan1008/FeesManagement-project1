package com.feesmanagement.logic;

import java.sql.SQLException;
import java.util.List;

import com.feesmanagement.dao.FindAllProductsDao;
import com.feesmanagement.model.Products;

public class BuyProducts {
	public static void getAllProducts() throws ClassNotFoundException, SQLException
	{ 
		FindAllProductsDao all=new FindAllProductsDao();
		List<Products> products=all.getAllProducts();
		for(Products product:products)
		{
			System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice()+" "+product.getWalletpoints());
		}
	}

}
