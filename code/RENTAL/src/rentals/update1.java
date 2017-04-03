package rentals;

import java.util.Scanner;    
import java.sql.*;
   

public class update1 
{   
 
public static void main(String args[])    
{    
    System.out.println("Welcome to database");   
    
    try    
    {    

        Scanner value = new Scanner(System.in);  
        
        System.out.println("daily rate");    
        String dr = value.nextLine();    
        
        System.out.println("weekly rate");    
        String wr = value.nextLine();
        
        System.out.println("car type");    
        String ct = value.nextLine(); 
         
        System.out.println("model");    
        String md = value.nextLine(); 
        
        System.out.println("Your Details are following.");    
    
        System.out.println("id :"+ " "+dr);    
        System.out.println("name :"+ " "+ct);    
        
        String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/rentals";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
         System.out.println("Connection is "+conn);
         
         String query = "update Car set Daily_rate = ? where Car_type = ? and MODEL= ? ";
         String query1 = "update Car set Weekly_rate = ? where Car_type = ? and MODEL= ?";

         PreparedStatement pst;
         PreparedStatement stmt;
         
	      pst = conn.prepareStatement(query);
	      
	      pst.setString (1, dr);
	      pst.setString (2, ct);
	      pst.setString (3, md);
	      
	      stmt = conn.prepareStatement(query1);
	      
	      stmt.setString (1, wr);
	      stmt.setString (2, ct);
	      stmt.setString (3, md);


	      pst.execute();
	      stmt.execute();
	      
	     
    System.out.println("data done");    
     
     conn.close();
   }
   
     
    catch(Exception e)    
    {
    	System.out.println(e);
    	}    
       
}    
}    