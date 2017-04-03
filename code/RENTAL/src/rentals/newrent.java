package rentals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class newrent {

	public static void main(String[] args) {
		 try
		    {
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/RENTALS";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
	           System.out.println("Connection is "+conn);
	           Scanner value = new Scanner(System.in);  
	           System.out.println("Enter Date in yyyy-mm-dd format:");
	           String date=value.nextLine();
	           Statement st = conn.createStatement();
	           
	           String query = "(select car.v_id,car.Cid,daily.Rental_idi,car.Car_type,car.MODEL from daily inner join rentals inner join car where car.V_id=rentals.V_id and rentals.Rental_idi=daily.Rental_idi and '"+date+"' between D_sdate and D_rdate) union (select car.v_id,car.Cid,weekly.Rental_idi,car.Car_type,car.MODEL from weekly inner join rentals inner join car where car.V_id=rentals.V_id and rentals.Rental_idi=weekly.Rental_idi and '"+date+"' between W_start_dt and W_Rdate);";


	           ResultSet set = st.executeQuery(query);
	           
               System.out.println("owner      type"); 

	           while (set.next()) {
	               String Cid = set.getObject(2).toString();
	               String Rental_idi = set.getObject(3).toString();
	               String V_id = set.getObject(1).toString();
	               String Car_type = set.getObject(4).toString();
	               String MODEL = set.getObject(5).toString();
 

	               System.out.println("" + Cid + " " + V_id + " " + Rental_idi + " " + Car_type + " " + MODEL );
	             
	           }
	           
	           
	           
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