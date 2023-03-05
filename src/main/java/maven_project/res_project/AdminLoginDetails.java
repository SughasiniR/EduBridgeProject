package maven_project.res_project;

public class AdminLoginDetails {


	static void checking() throws InvalidNameAndId{    	
    	System.out.println(" Enter Name and Password to login ");
		System.out.print("Enter the Name: ");
		String name=ScannerClass.scanner.nextLine();
		System.out.println();
		System.out.print("Enter the Password: ");
		String password=ScannerClass.scanner.nextLine();
       if(name.equals("admin") && password.equals("admin"))
       {  
    	   System.out.println();
    	   System.out.println(" -----Welcome To Heaven's Kitchen!!!----- ");     
       }  
       else
       {   
           throw new InvalidNameAndId("Name/Password is Invalid"); 
       }   
    }   
}

class InvalidNameAndId  extends Exception  
{  
    public InvalidNameAndId (String customException)  
    {   
        super(customException);  
    }  
}