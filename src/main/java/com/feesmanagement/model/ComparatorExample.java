package com.feesmanagement.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.feesmanagement.dao.StationaryDao;
import com.feesmanagement.model.Stationary;

public class ComparatorExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			List<Stationary> list=StationaryDao.allProducts();
//			List<Stationary> list=new ArrayList<Stationary>();
//			list.add(new Stationary(5,"Hari"));
//			list.add(new Stationary(4,"Dev"));
			Collections.sort(list,new exmp());
			for(Stationary stationary:list)
			{
			 System.out.println(stationary.getPrice()+"  "+stationary.getName());
			}
			
			

	}

}
