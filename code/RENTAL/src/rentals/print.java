package rentals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class print {

	public static void main(String[] args) {
		 try
		    {
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/RENTALS";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
	           System.out.println("Connection is "+conn);
	           
	           
	           Statement st = conn.createStatement();
	           
	           String query = "select * from owner ;";
	           ResultSet set = st.executeQuery(query);
	           
               System.out.println("owner      type"); 

	           while (set.next()) {
	               String Owner_id = set.getObject(1).toString();
	               String Ownertype = set.getObject(2).toString();
	               System.out.println("" + Owner_id + " " + Ownertype);
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