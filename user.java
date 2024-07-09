package com.project.stock;

import java.util.Scanner;

public class user {
	public String name;
	public String stock[];
	public double bP[];
	public double bal;
	Scanner sc=new Scanner(System.in);
	public void getData()
	{
		
		System.out.println("Enter name and balance");
		name=sc.next();
		bal=sc.nextDouble();
		
		
	}
	public void displayStock()
	{
		System.out.println("Stock \t Buying price \t Selling price ");
		System.out.println("Amazon \t 30 \t\t 20");
		System.out.println("IBM \t 45 \t\t 23");
		System.out.println("Facebook 24 \t\t 12");
	}
	public void transact()
	{
		System.out.println("Do you want to buy or sell?");
		String ans=sc.next();
		if(ans.equals("buy"))
		{
			System.out.println("Which one?");
			String comp=sc.next();
			if(comp.charAt(0)=='A')
			{
				bal=bal-30;
				System.out.println("'Amazon' Stock bought! Balance -"+bal);
				
			}
			else if(comp.charAt(0)=='I')
			{
				bal=bal-45;
				System.out.println("'IBM' Stock bought! Balance -"+bal);
			}
			else
			{
				bal=bal-24;
				System.out.println("'Facebook' Stock bought! Balance -"+bal);
			}
		}
		else
		{
			System.out.println("Which one?");
			String comp=sc.next();
			if(comp.charAt(0)=='A')
			{
				bal=bal+20;
				System.out.println("'Amazon' Stock sold! Balance -"+bal);
			}
			else if(comp.charAt(0)=='I')
			{
				bal=bal+23;
				System.out.println("'IBM' Stock sold! Balance -"+bal);
			}
			else
			{
				bal=bal+12;
				System.out.println("'Facebook' Stock sold! Balance -"+bal);
			}
		}
		
	}
}
