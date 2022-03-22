package com.feesmanagement.logic;

import com.feesmanagement.dao.FeesStructureDao;
import com.feesmanagement.model.FeesStructure;

public class FeesStructureLogic {
	public static void feesStructure(int year,String branch) throws Exception
	{
		FeesStructure fees=FeesStructureDao.getFeesStructure(year,branch);
		int firstSemesterFees=Integer.parseInt(fees.getFirstSemesterFees());
		int secondSemesterFees=Integer.parseInt(fees.getSecondSemesterFees());
		int hostelFees=Integer.parseInt(fees.getHotelFees());
		int transportFees=Integer.parseInt(fees.getTransportFees());
		int studentType=HostelCheck.hostelCheck();
		if(studentType==1)
		{
			int totalFees=firstSemesterFees+secondSemesterFees+hostelFees;
			System.out.println("First semester fee  : "+firstSemesterFees);
			System.out.println("Second semester fee : "+secondSemesterFees);
			System.out.println("Hostel fees         : "+hostelFees);
			System.out.println("Total fees          : "+totalFees);
			
		}
		else if(studentType==2)
		{
			int totalFees=firstSemesterFees+secondSemesterFees;
			System.out.println("First semester fee  : "+firstSemesterFees);
			System.out.println("Second semester fee : "+secondSemesterFees);
			System.out.println("Total fees          : "+totalFees);
			
		}
		else if(studentType==3)
		{
			int totalFees=firstSemesterFees+secondSemesterFees+transportFees;
			System.out.println("First semester fee  : "+firstSemesterFees);
			System.out.println("Second semester fee : "+secondSemesterFees);
			System.out.println("Transport fee       : "+transportFees);
			System.out.println("Total fees          : "+totalFees);
			
		}
	}
	

}
