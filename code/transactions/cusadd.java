
import java.util.Scanner;    
import java.sql.*;
   

public class cusadd 
{   
 
public static void main(String args[])    
{    
    System.out.println("Welcome to database");    
    try    
    {    

        Scanner value = new Scanner(System.in);  
        
        System.out.println("Enter cid");    
        String id = value.nextLine();    
        
        System.out.println("Enter Flname");    
        String name = value.nextLine();
        
        System.out.println("Enter phone");    
        String ph = value.nextLine();    
        
        System.out.println("Enter address");    
        String add = value.nextLine(); 
        
        System.out.println("Enter gender");    
        String gen = value.nextLine();    
        
        System.out.println("Enter age");    
        String agee = value.nextLine(); 
        
              
        System.out.println("Your Details are following.");    
    
        System.out.println("id :"+ " "+id);    
        System.out.println("name :"+ " "+name);    
        System.out.println("phno :"+ " "+ph);    
        System.out.println("address :"+ " "+add);    
        System.out.println("gender :"+ " "+gen);    
        System.out.println("age :"+ " "+agee);
        
        String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/rentals";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
         System.out.println("Connection is "+conn);
         
         String query = " insert into Customer ( Cid, FLname, Phone, Address, Gender, Age)"
	   		        + " values ( ?, ?, ?, ?, ?, ?)";
         
         PreparedStatement pst;
         
	      pst = conn.prepareStatement(query);
	      
	      pst.setString (1, id);
	      pst.setString (2, name);
	      pst.setString (3, ph);
	      pst.setString (4, add);
	      pst.setString (5, gen);
	      pst.setString (6, agee);
	      
	      pst.execute();
	      
	     
    System.out.println("data done");    
     
     conn.close();
   }
   
     
    catch(Exception e)    
    {
    	System.out.println(e);
    	}    
       
}    
}    