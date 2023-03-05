package maven_project.res_project;


public class Admin {
	public static void main(String[] args) {
		
		 try  
	        {  
			 AdminLoginDetails.checking(); 
			 boolean assign=true;
			 while(assign) {
				 System.out.println("\n1. Modify Heaven's Kitchen Dishes \n2. To Retrieve HK Dishes \n3. To Modify Today's Menu \n4. To Retrieve Today's Menu \n5.To Logout");
				    System.out.print("\nEnter : ");
					int num=ScannerClass.scanner.nextInt();
					switch (num) {
					case 1:
						HKDishes.modifyHKDishes();
						break;
					case 2:						
						HKDishes.dishRetrieve();
						break;
					case 3:
						MenuUpdate.modifyTodayMenu();
						break;
					case 4:
						MenuUpdate.menuRetrieve();
						break;
					case 5:
						System.out.println("Successfully Logged Out");
					    assign=false;
					    break;
					default:
						System.out.println("Enter correct digit");
					}
				    }
		    } 
	     catch (InvalidNameAndId ex) {  
	            System.out.println(ex);
	     }  
		 catch(Exception e) {
					e.printStackTrace();
		 }
		 
	}
	
    
}


