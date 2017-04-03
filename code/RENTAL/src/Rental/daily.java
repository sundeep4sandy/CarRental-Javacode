package Rental;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import au.com.bytecode.opencsv.CSVReader;

public class daily {

	public static void main(String[] args) {
		try
	    {
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/RENTALS";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "admin");
           System.out.println("Connection is "+conn);
           
           String query = " insert into daily ( Rental_id, Rental_idi, D_sdate, No_days, D_rdate, Amt_due)"
   		        + " values ( ?, ?, ?, ?, ?, ? )";
           PreparedStatement pst;
           CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Rishi\\Desktop\\sandy\\DATA BASE\\project3\\daily.csv"));
  	     String [] nextLine;
  	     while ((nextLine = reader.readNext()) != null) 
  	  {
  	         //nextLine[] is an array of values from the line
  	    	query = " insert into daily ( Rental_id, Rental_idi, D_sdate, No_days, D_rdate, Amt_due)"
  	   		        + " values ( ?, ?, ?, ?, ?, ? )";

	    	 System.out.println("its reading" );

		      pst = conn.prepareStatement(query);

		      pst.setString (1, nextLine[0]);
		      pst.setString (2, nextLine[1]);
		      pst.setString (3, nextLine[2]);
		      pst.setString (4, nextLine[3]);
		      pst.setString (5, nextLine[4]);
		      pst.setString (6, nextLine[5]);
		      pst.execute();
		      

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
