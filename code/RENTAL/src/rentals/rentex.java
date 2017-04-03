package rentals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class rentex {

	public static void main(String[] args) {
		 try
		    {
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/RENTALS";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
	           System.out.println("Connection is "+conn);
	           
	           
	           Statement st = conn.createStatement();
	           
	            String query = "select Cid,Status,V_id from car where status= 'yes';";
	           
	           ResultSet set = st.executeQuery(query);
	           
               System.out.println("owner      vid"); 

	           while (set.next()) {
	               String Cid = set.getObject(1).toString();
	               String status = set.getObject(2).toString();
	               String V_id = set.getObject(3).toString();

	               System.out.println("" + Cid + " " + V_id + " " + status);
	             
	           }
	         //update  
	           Scanner value = new Scanner(System.in);  
	           
	           System.out.println("Enter V_id");    
	           String vid = value.nextLine();   

	           System.out.println("Enter Cid");    
	           String cid = value.nextLine();
	           
	           System.out.println("Enter Rental_idi");    
	           String rid = value.nextLine();    
	           
	           System.out.println("Enter Amount_paid");    
	           String amt = value.nextLine(); 
	           
	           System.out.println("Your Details are following.");    
	           
	           System.out.println("id :"+ " "+vid);    
	           System.out.println("name :"+ " "+cid);    
	           System.out.println("phno :"+ " "+rid);    
	           System.out.println("address :"+ " "+amt); 
	           String query2 = " insert into Rentals ( V_id, Cid, Rental_idi, Amount_paid)"
		   		        + " values ( ?, ?, ?, ?)";
	         
	         PreparedStatement smt;
	         
		      smt = conn.prepareStatement(query2);
		      
		      smt.setString (1, vid);
		      smt.setString (2, cid);
		      smt.setString (3, rid);
		      smt.setString (4, amt);
		    
		      
		      smt.execute();
	           
		      conn.close();
	           }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
		  }
		}