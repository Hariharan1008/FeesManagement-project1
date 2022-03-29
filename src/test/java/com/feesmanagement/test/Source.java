package com.feesmanagement.test;

import java.util.*;
import java.lang.*;

class Population{
    HashMap<String,Integer>populationData = new HashMap<String,Integer>();
    String country;
    Integer total=0;
    int max=0;
    public String maxPopulation(){
        for(String i:populationData.keySet())
        {
        	Integer l=populationData.get(i);
        	if(l>max)
        	{
        		country=i;
        	}
        }
        return country;
    }

    public int totalPopulation()
    {
       for(String i:populationData.keySet())
        {
        	int l=populationData.get(i);
        	this.total=this.total+l;
        }
        
       return this.total;
    }
}
public class Source {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Population obj = new Population();
        obj.populationData.put("India",11000);
        obj.populationData.put("UK",9000);
        obj.populationData.put("USA",100);
        String max = obj.maxPopulation();
        System.out.println(max);
        Integer totalPopulation = obj.totalPopulation();
        System.out.println(totalPopulation);
    }
}