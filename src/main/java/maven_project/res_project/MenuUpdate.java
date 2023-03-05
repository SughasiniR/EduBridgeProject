package maven_project.res_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.lang3.math.NumberUtils;

public class MenuUpdate {
	
	static Connection connection;
	public static void modifyTodayMenu() throws Exception{
		 System.out.println("\n1.To create new Menu\n2.To modify in existing Menu");
		 System.out.print("Enter: ");
		 int number=ScannerClass.scanner.nextInt();
		 boolean value=false;
		 if(number==1) {
			 truncaterecords();
			 value=true;
		 }
		 else if(number==2) {
			 value=true;
		 }
		 System.out.println("\nEnter dish ID to add \nEnter 'exit' to Terminate process");
		 while(value){
			 System.out.print("\nEnter: ");
			 String num = ScannerClass.scanner.next();  
			 if(NumberUtils.isDigits(num)) {
				 todaysMenu(num);	
				 
				 value=true;
			 }
			 else {
				 value=false;
				 System.out.println(" Succesfully dishes updated ");
			 }
       } 
	}
	
	//-----------------------------------Menu Add--------------------------------------------
	public static void todaysMenu(String a) throws Exception{
		connection=DBConnection.dbConnection();	
		String query="INSERT INTO menu SELECT * FROM dish_details WHERE dish_id="+a+"";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		int count=preparedStatement.executeUpdate();
		if(count>0)
		{
			System.out.println("Data updated successfully");
		}
		else
		{
			System.out.println("Please enter correct id to update sdata");
		}
		preparedStatement.close();
		connection.close();
	}
	//----------------------------------Truncate Menu Table----------------------------------------------
	public static void truncaterecords() throws Exception {
		connection=DBConnection.dbConnection();
		String query="TRUNCATE TABLE menu";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	//----------------------------------------------Menu Retrieve----------------------------------------------
	public static void menuRetrieve() throws Exception{
		connection=DBConnection.dbConnection();
		Statement stmt=connection.createStatement();
		String query="select * from menu"; 
		ResultSet resultSet=stmt.executeQuery(query);
		System.out.println("---------------------------------------------------------------------");
		while(resultSet.next())
		{
			System.out.println("Id : "+resultSet.getInt(1)+"\t Name : "+resultSet.getString("dish_name")+"\t\t Price : "+resultSet.getInt("dish_price")+"\t Quantity : "+resultSet.getInt(4));
		}
		System.out.println("---------------------------------------------------------------------");
		resultSet.close();
		stmt.close();
		connection.close();
	}
}

