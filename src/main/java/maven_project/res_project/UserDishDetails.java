package maven_project.res_project;

import org.apache.commons.lang3.math.NumberUtils;

public class UserDishDetails {

	public static void main(String[] args) {
		try {
			System.out.println("                    Welcome To Heaven's Kitchen !!!  ");
			System.out.println("                             List of Dishes  ");
			UserDish.truncaterecords();
			UserDish.menuRetrieve();
			System.out.println("\nPlace your orders!!!");
			System.out.println("Enter dish Id to add to your Menu \nEnter EXIT after adding all the dishes");
			boolean assign=true;		
			while(assign){
				System.out.print("\nEnter : ");
				String getMenu=ScannerClass.scanner.next();
				 if(NumberUtils.isDigits(getMenu)) {
					 UserDish.menu(getMenu);				 	 	
					 assign=true;
				 }
				 else {
					 assign=false;
				 }
	        } 
			System.out.println("\n                             ---- List of Ordered Dishes ---- ");
			UserDish.customermenu();
			System.out.println();
			int total=UserDish.getBill();
			System.out.print("Your Bill : "+total);
			System.out.println("\nThank you for ordering !!! \nYour order will be delivered shortly \nPlease Visit Again !!!");
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

}


