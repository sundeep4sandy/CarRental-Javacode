
import java.util.Scanner;    
import java.sql.*;
   

public class caradd 
{   
 
public static void main(String args[])    
{    
    System.out.println("Welcome to database");    
    try    
    {    

        Scanner value = new Scanner(System.in);  
        
        System.out.println("Enter ownerid");    
        String id = value.nextLine();    
        
        System.out.println("Enter licencse num");    
        String lino = value.nextLine();
        
        System.out.println("Enter vid");    
        String vid = value.nextLine();    
        
        System.out.println("Enter status");    
        String stat = value.nextLine(); 
        
        System.out.println("Enter year");    
        String yr = value.nextLine();    
        
        System.out.println("Enter model");    
        String mdl = value.nextLine(); 
        
      
        System.out.println("Enter location");    
        String loc = value.nextLine();    
        
        System.out.println("Enter drate");    
        String dr = value.nextLine(); 
        
        System.out.println("Enter wrate");    
        String wr = value.nextLine();    
        
        System.out.println("cid");    
        String cd = value.nextLine(); 
        
        System.out.println("car type");    
        String ctpe = value.nextLine();
        
        
              
        System.out.println("Your Details are following.");    
    
        System.out.println("id :"+ " "+id);    
        System.out.println("licence num :"+ " "+lino);    
        System.out.println("vechicle id :"+ " "+vid);    
        System.out.println("status :"+ " "+stat);    
        System.out.println("year"+ " "+yr);    
        System.out.println("model :"+ " "+mdl);
        System.out.println("location :"+ " "+loc);    
        System.out.println("daily rate :"+ " "+dr);    
        System.out.println("weekly rate :"+ " "+wr);    
        System.out.println("cid :"+ " "+cd);    
        System.out.println("car type :"+ " "+ctpe);
        	
        
        String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/rentals";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
         System.out.println("Connection is "+conn);
         
         String query = " insert into Car ( Owner_id, License_no, V_id, Status, YEAR, MODEL, Location, Daily_rate, Weekly_rate, Cid, Car_type)"
	   		        + " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         
         PreparedStatement pst;
         
	      pst = conn.prepareStatement(query);
	      
	      pst.setString (1, id);
	      pst.setString (2, lino);
	      pst.setString (3, vid);
	      pst.setString (4, stat);
	      pst.setString (5, yr);
	      pst.setString (6, mdl);
	      pst.setString (7, loc);
	      pst.setString (8, dr);
	      pst.setString (9, wr);
	      pst.setString (10, cd);
	      pst.setString (11, ctpe);
	      
	     
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