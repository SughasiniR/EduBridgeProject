package maven_project.res_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.lang3.math.NumberUtils;

public class HKDishes {
	static Connection connection;
	public static void modifyHKDishes() throws Exception{
		System.out.println();
	    System.out.println(" ---- To Modify Heaven's Kitchen Dish List ---- ");
		boolean assign=true;
		while(assign) {
		System.out.println("\n1.Create new dish record \n2.Retrieve all dishes details \n3.Update dish \n4.Delete dish \nEnter 'exit' to Terminate process");		 
	    System.out.print("\nEnter : ");
		String num=ScannerClass.scanner.next();
		if(NumberUtils.isDigits(num)) {
		switch (num) {
		case "1":
			dishNew();
			break;
		case "2":
			dishRetrieve();
			break;
		case "3":
			dishUpdate();
			break;
		case "4":
			dishDelete();
			break;
		default:
			System.out.println("Enter correct digit");
		}
		}
		else {
			System.out.println("Successfully modification made");
			break;
		}
	    }
	}
	
	//------------------------------------Dish Detail Retrieve------------------------------------------
	public static void dishRetrieve() throws Exception{
		    connection=DBConnection.dbConnection();
			Statement stmt=connection.createStatement();
			String query="select * from dish_details"; 
			ResultSet result=stmt.executeQuery(query);
			System.out.println("---------------------------------------------------------------------");
			while(result.next())
			{
				System.out.print("Id : "+result.getInt(1)+"\t Name : "+result.getString("dish_name"));
				System.out.println("\t\t Price : "+result.getInt("dish_price")+"\t Quantity : "+result.getInt(4));
			}
			System.out.println("---------------------------------------------------------------------");
			result.close();
			stmt.close();
			connection.close();
	}
	
	//---------------------------Update-----------------------------------------------------
		public static void dishUpdate() throws Exception {
			connection=DBConnection.dbConnection();
			System.out.print("Enter Dish ID to update  ");
			int dish=ScannerClass.scanner.nextInt();
			Statement stmt=connection.createStatement();
			String query1="SELECT * FROM dish_details WHERE dish_id='"+dish+"'";
			ResultSet result=stmt.executeQuery(query1);
			if(result.next())
			{
				System.out.println("\nWhat you need to update..??");
				System.out.println("1.Name update ");
				System.out.println("2.Price update ");
				System.out.println("3.Quantity update ");
				int number=ScannerClass.scanner.nextInt();
				String parameter=null,value=null;
				switch (number) {
				case 1:
					System.out.print("Enter Name :");
					parameter="dish_name=";
					value=ScannerClass.scanner.next();
					break;
				case 2:
					System.out.print("Enter Price :");
					parameter="dish_price=";
					value=ScannerClass.scanner.next();
					break;
				case 3:
					System.out.print("Enter Quantity :");
					parameter="dish_quantity=";
					value=ScannerClass.scanner.next();
					break;
				}
				String query="UPDATE dish_details SET "+parameter+" '"+value+"' WHERE dish_id='"+dish+"'";
				PreparedStatement preparedstatement=connection.prepareStatement(query);
				int count=preparedstatement.executeUpdate();
				if(count>0)
				{
					System.out.println("Data updated successfully");
				}
				else
				{
					System.out.println("Unable to update data");
				}
				
				preparedstatement.close();
			}
			else
			{
				System.out.println("Enter Correct ID to update");
			}
			result.close();
			stmt.close();
			connection.close();
		}	
		//---------------------------------Create--------------------------------------------------------
	public static void dishNew() throws Exception{
		    connection=DBConnection.dbConnection();
			System.out.print("\nEnter the Name : ");
			String name=ScannerClass.scanner.next();
			System.out.print("Enter the Price : ");
			int price=ScannerClass.scanner.nextInt();
			System.out.print("Enter the Quantity : ");
			int quantity=ScannerClass.scanner.nextInt();
			String query="insert into dish_details(dish_name,dish_price,dish_quantity) values(?,?,?)";
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			preparedstatement.setString(1, name);
			preparedstatement.setInt(2, price);
			preparedstatement.setInt(3, quantity);
			int count=preparedstatement.executeUpdate();
			if(count>0)
			{
				System.out.println("Created successfully");
			}
			else
			{
				System.out.println("Oops! Unable to create. Please try again!!");
			}
			preparedstatement.close();
			connection.close();
		}	
	//----------------------------------Delete----------------------------------------------------------
	public static void dishDelete() throws Exception{
		    connection=DBConnection.dbConnection();
			System.out.println("Please enter which Dish ID to be deleted");
			int dishid=ScannerClass.scanner.nextInt();
			String query="DELETE from dish_details WHERE dish_id='"+dishid+"' ";
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			int count=preparedstatement.executeUpdate();
			if(count>0)
			{
				System.out.println("Data Deleted Successfully");
			}
			else
			{
				System.out.println("Unable to delete data");
			}
			preparedstatement.close();
			connection.close();
	}

}

