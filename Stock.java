package com.project.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Stock {
	
	public static void display()
	{
		System.out.println("*****STOCK VALUES TODAY*****");
		System.out.println("Stock       BP     SP");
		System.out.println("1.Apple     100    60");
		System.out.println("2.Google    90     56");
		System.out.println("3.Microsoft 219    95");
		System.out.println("4.Pepsi     334    103");
		System.out.println("5.Ford      180    67");
		System.out.println("6.Infosys   259    130");
	}
	public static void buy(int id,double balance)
	{
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_user_db","root","#Chin@acharya19");
			System.out.println("Enter which stock you want to buy");
			int n=sc.nextInt();
			switch(n)
			{
				case 1: System.out.println("Apple bought!");
						balance=balance-100;
						System.out.println("Your balance now: "+balance);
						String sql = "INSERT INTO stock (UserId,Stock_name,Buying_price) VALUES (?, ?, ?)";
				        PreparedStatement stmt = con.prepareStatement(sql);
				        stmt.setInt(1,id); 
			            stmt.setString(2, "Apple"); 
			            stmt.setDouble(3, 100.00);
			            stmt.executeUpdate();
			            stmt.close();
						break;
				case 2:	System.out.println("Google bought!");
						balance=balance-90;
						System.out.println("Your balance now: "+balance);
						String sq2 = "INSERT INTO stock (UserId,Stock_name,Buying_price) VALUES (?, ?, ?)";
				        PreparedStatement stmt2 = con.prepareStatement(sq2);
				        stmt2.setInt(1,id); 
			            stmt2.setString(2, "Google"); 
			            stmt2.setDouble(3, 90.00);
			            stmt2.executeUpdate();
			            stmt2.close();
						break;	
				case 3:System.out.println("Microsoft bought!");
						balance=balance-219;
						System.out.println("Your balance now: "+balance);
						String sq3 = "INSERT INTO stock (UserId,Stock_name,Buying_price) VALUES (?, ?, ?)";
				        PreparedStatement stmt3 = con.prepareStatement(sq3);
				        stmt3.setInt(1,id); 
			            stmt3.setString(2, "Microsoft"); 
			            stmt3.setDouble(3, 219.00);
			            stmt3.executeUpdate();
			            stmt3.close();
						break;
				case 4:System.out.println("Pepsi bought!");
						balance=balance-334;
						System.out.println("Your balance now: "+balance);
						String sq4 = "INSERT INTO stock (UserId,Stock_name,Buying_price) VALUES (?, ?, ?)";
				        PreparedStatement stmt4 = con.prepareStatement(sq4);
				        stmt4.setInt(1,id); 
			            stmt4.setString(2, "Pepsi"); 
			            stmt4.setDouble(3, 334.00);
			            stmt4.executeUpdate();
			            stmt4.close();
						break;
				case 5:System.out.println("Ford bought!");
						balance=balance-180;
						System.out.println("Your balance now: "+balance);
						String sq5 = "INSERT INTO stock (UserId,Stock_name,Buying_price) VALUES (?, ?, ?)";
				        PreparedStatement stmt5 = con.prepareStatement(sq5);
				        stmt5.setInt(1,id); 
			            stmt5.setString(2, "Ford"); 
			            stmt5.setDouble(3, 180.00);
			            stmt5.executeUpdate();
			            stmt5.close();
						break;
				case 6:System.out.println("Infosys bought!");
						balance=balance-259;
						System.out.println("Your balance now: "+balance);
						String sq6 = "INSERT INTO stock (UserId,Stock_name,Buying_price) VALUES (?, ?, ?)";
				        PreparedStatement stmt6 = con.prepareStatement(sq6);
				        stmt6.setInt(1,id); 
			            stmt6.setString(2, "Infosys"); 
			            stmt6.setDouble(3, 259.00);
			            stmt6.executeUpdate();
			            stmt6.close();
						break;
				default:
					System.out.println("Please enter properly");
				
			}
			String sqlU="UPDATE user_info SET Balance = ? WHERE Id = ?";
			PreparedStatement stmtU=con.prepareStatement(sqlU); 
			stmtU.setDouble(1, balance);
	        stmtU.setInt(2, id);
	        stmtU.executeUpdate();
	        stmtU.close();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("SQL exception");
			e.printStackTrace();
		}
		
		sc.close();
		
	}
	public static void sell(int id,int userid,String stock,double bp,double balance)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Your stocks are: ");
		
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_user_db","root","#Chin@acharya19");
			Statement stmt=con.createStatement();
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
			System.out.println("Which stock do you want to sell");
			char ans=sc.next().charAt(0);
			switch(ans)
			{
				case 'A': System.out.println("Apple sold!");
						  balance=balance+60;
					      System.out.println("Your balance now: "+balance);
					      String sqlA="DELETE FROM stock WHERE Stock_name = ?";
					      PreparedStatement stmtA=con.prepareStatement(sqlA);
					      stmtA.setString(1, "Apple");
					      stmtA.executeUpdate();
					      stmtA.close();
						  break;
				case 'G':System.out.println("Google sold!");
					     balance=balance+56;
						 System.out.println("Your balance now: "+balance);
						 String sqlG="DELETE FROM stock WHERE Stock_name = ?";
					      PreparedStatement stmtG=con.prepareStatement(sqlG);
					      stmtG.setString(1, "Google");
					      stmtG.executeUpdate();
					      stmtG.close();
						 break;
				case 'M': System.out.println("Microsoft sold!");
						  balance=balance+95;
						  System.out.println("Your balance now: "+balance);
						  String sqlM="DELETE FROM stock WHERE Stock_name = ?";
					      PreparedStatement stmtM=con.prepareStatement(sqlM);
					      stmtM.setString(1, "Microsoft");
					      stmtM.executeUpdate();
					      stmtM.close();
						  break;
				case 'P':System.out.println("Pepsi sold!");
						 balance=balance+103;
						 System.out.println("Your balance now: "+balance);
						 String sqlP="DELETE FROM stock WHERE Stock_name = ?";
					      PreparedStatement stmtP=con.prepareStatement(sqlP);
					      stmtP.setString(1, "Pepsi");
					      stmtP.executeUpdate();
					      stmtP.close();
						 break;
				case 'F': System.out.println("Ford sold!");
						  balance=balance+67;
						  System.out.println("Your balance now: "+balance);
						  String sqlF="DELETE FROM stock WHERE Stock_name = ?";
					      PreparedStatement stmtF=con.prepareStatement(sqlF);
					      stmtF.setString(1, "Ford");
					      stmtF.executeUpdate();
					      stmtF.close();
						  break;
				case 'I':System.out.println("Infosys sold!");
						 balance=balance+130;
						 System.out.println("Your balance now: "+balance);
						 String sqlI="DELETE FROM stock WHERE Stock_name = ?";
					      PreparedStatement stmtI=con.prepareStatement(sqlI);
					      stmtI.setString(1, "Apple");
					      stmtI.executeUpdate();
					      stmtI.close();
						 break;
				default:System.out.println("Enter properly");
			}
			String sqlU="UPDATE user_info SET Balance = ? WHERE Id = ?";
			PreparedStatement stmtU=con.prepareStatement(sqlU); 
			stmtU.setDouble(1, balance);
	        stmtU.setInt(2, id);
	        stmtU.executeUpdate();
	        stmtU.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
		
	
	
	
}
