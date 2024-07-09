package com.project.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static int id,userid;
	static String name,stock;
	static double balance,bp;
	public static void main(String[]args)
	{
		boolean found=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name");
		String Name=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_user_db","root","#Chin@acharya19");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM stock_user_db.user_info");
			while(rs.next())
			{
				id=rs.getInt("Id");
				 name=rs.getNString("Name");
				 balance=rs.getDouble("Balance");
				if(name.equals(Name))
				{
					found=true;
					System.out.println("Welcome, "+Name);
					System.out.println("Your balance: "+balance);
					System.out.println("Stocks held: ");
					ResultSet rs0=stmt.executeQuery("SELECT * FROM stock_user_db.stock");
					while(rs0.next())
					{
						
						 userid=rs0.getInt("UserId");
						stock=rs0.getNString("Stock_name");
						 bp=rs0.getDouble("Buying_price");
						if(userid==id)
						{
							System.out.println(stock+" "+bp);
						}
					}
					break;
				}
				
				
			}
			if(found==false)
			{
				System.out.println("Enter your account balance ");
				balance=sc.nextDouble();
				
				String sql = "INSERT INTO user_info (Name,Balance) VALUES ( ?, ?)";
				PreparedStatement stmtN=con.prepareStatement(sql);
				
				stmtN.setString(1, Name);
				stmtN.setDouble(2, balance);
				stmtN.executeUpdate();
				stmtN.close();
				
			}
			rs.close();
			Stock.display();
			System.out.println("Do you want to buy or sell (Press x to exit)");
			System.out.println("PS: If you are new, you can only buy");
			char ans=sc.next().charAt(0);
			switch(ans)
			{
			 case 'b': Stock.buy(id,balance);
			break;
			 case 's':Stock.sell(id, userid, stock, bp, balance);
			 break;
			default:
				System.out.println("EXIT");
				break;
			}
			
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("SQL exception");
			e.printStackTrace();
		}
	}
	
	
}
