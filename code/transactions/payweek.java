
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class payweek {

	public static void main(String[] args) {
		 try
		    {
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/RENTALS";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
	           System.out.println("Connection is "+conn);
	           
	          //cal 
	           Statement st = conn.createStatement();
	           
	           	Scanner in = new Scanner(System.in);
	           
	           String c;
	           
	           System.out.println("id");
	           c = in.nextLine();
	           System.out.println("You entered id "+c);
	           
	           String query = "select ((w.No_weeks *  c.Weekly_rate)- r.Amount_paid) as due from weekly as w, car as c, rentals as r where w.Rental_idi like \'" + c + "\'  and  c.V_id = r.V_id and w.Rental_idi = r.Rental_idi ; ;";
	           ResultSet set = st.executeQuery(query);
	           
               System.out.println("Amt_due  "); 

	           while (set.next()) {
	               String Amt_due  = set.getObject(1).toString();

	               System.out.println("" + Amt_due  );
	               
	             //update
	               Scanner value = new Scanner(System.in);  
	               
	               System.out.println("type due amount");    
	               String dr = value.nextLine(); 
	               System.out.println("rental idi");    
	               String id = value.nextLine(); 
	               
	               PreparedStatement stmt;
	               String query2 = "update weekly set Amt_due = ? where Rental_idi = ?";
	               
	     	      stmt = conn.prepareStatement(query2);
	     	      
	     	      stmt.setString (1, dr);
	     	      stmt.setString (2, id);
	     	      
	    	      stmt.execute();

	              
	           }
		      conn.close();
	           }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
		  }
		}