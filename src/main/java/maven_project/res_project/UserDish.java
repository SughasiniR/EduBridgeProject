package maven_project.res_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDish {

	static Connection connection;
	public static void menuRetrieve() throws Exception{
		connection=DBConnection.dbConnection();
		Statement stmt=connection.createStatement();
		String query="select * from menu"; 
		ResultSet result=stmt.executeQuery(query);
		System.out.println("---------------------------------------------------------------------");
		while(result.next())
		{
			System.out.println("Id : "+result.getInt(1)+"\t Name : "+result.getString("dish_name")
			+"\t\t Price : "+result.getInt("dish_price")+"\t Quantity : "+result.getInt(4));
		}
		System.out.println("---------------------------------------------------------------------");
		result.close();
		stmt.close();
		connection.close();
}
	
	public static void menu(String dishID) throws Exception{
		connection=DBConnection.dbConnection();		
		String query="INSERT INTO customer(dish_id,dish_name,rate) SELECT dish_id,dish_name,dish_price FROM menu WHERE dish_id="+dishID+"";
		PreparedStatement preparedStmt=connection.prepareStatement(query);
		int count1=preparedStmt.executeUpdate();
		if(count1>0) {
			System.out.print("Enter Quantity of Dish : ");
			int quantity=ScannerClass.scanner.nextInt();		
			String query1="UPDATE customer SET dish_quantity="+quantity+" WHERE dish_id="+dishID+"";
			PreparedStatement preparedStmt1=connection.prepareStatement(query1);
			preparedStmt1.executeUpdate();
			Statement stmt=connection.createStatement();
			String query4="select dish_price from menu WHERE dish_id="+dishID+""; 
			ResultSet result=stmt.executeQuery(query4);
			int sum=0;
			while(result.next()) {
			int prs=result.getInt(1);
			sum=prs*quantity;
			}
			stmt.close();
			preparedStmt1.close();
			result.close();
			String query2="UPDATE customer SET amount="+sum+" WHERE dish_id="+dishID+"";//update query to set amount(qty*dish_price) for each dish
			PreparedStatement preparedStmt2=connection.prepareStatement(query2);		
			int count=preparedStmt2.executeUpdate();
			preparedStmt2.close();
			if(count>0)
			{
				System.out.println("Item added successfully");
			}
			else
			{
				System.out.println("Item not added");
			}
		}
		else
		{
			System.out.println("Please Enter correct ID");
		}
		
		preparedStmt.close();
		connection.close();
		
	}
	
	public static void customermenu() throws Exception{
		connection=DBConnection.dbConnection();
		Statement stmt=connection.createStatement();
		String query="select * from customer"; 
		ResultSet result=stmt.executeQuery(query);
		System.out.println("--------------------------------------------------------------------------------------");
		while(result.next())
		{
			System.out.println("Id : "+result.getInt(1)+"\t Name : "+result.getString("dish_name")
			+"\t\t Rate : "+result.getInt(3)+"\t Quantity : "+result.getInt(4)+"\t Amount : "+result.getInt(5));
		}
		System.out.println("--------------------------------------------------------------------------------------");
		result.close();
		stmt.close();
		connection.close();
}
	
	public static int getBill() throws Exception{
		connection=DBConnection.dbConnection();
		Statement stmt=connection.createStatement();
		String query="select amount from customer"; 
		ResultSet result=stmt.executeQuery(query);
		int sum=0;
		while(result.next())
		{
			sum+=result.getInt(1);
		}
		
		result.close();
		stmt.close();
		connection.close();
		return sum;
	}
	
	public static void truncaterecords() throws Exception {
		connection=DBConnection.dbConnection();
		String query="TRUNCATE TABLE customer";
		PreparedStatement preparedStmt=connection.prepareStatement(query);
		preparedStmt.executeUpdate();
		preparedStmt.close();
		connection.close();
	}

}
