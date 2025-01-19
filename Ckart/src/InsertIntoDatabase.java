import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class InsertIntoDatabase 
{
	public static void insert(String productID,String productName,String company,String quantity,String priceperunit) 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				   
	    String insertQuery = "insert into productdetails values(?,?,?,?,?)";
	    PreparedStatement preparedStatement;
		
	    preparedStatement = conn.prepareStatement(insertQuery);
	    preparedStatement.setString(1,productID);
	    preparedStatement.setString(2,productName);
	    preparedStatement.setString(3,company);
	    preparedStatement.setString(4,quantity);
	    preparedStatement.setString(5,priceperunit);
			
	    preparedStatement.executeUpdate();
	    System.out.println("Data  Successfully Inserted !!!");
	    JOptionPane.showMessageDialog(null,"Data  Successfully Inserted !!!");
	  }
	 catch(Exception e)
	 {
		 System.out.println(e);
		 JOptionPane.showMessageDialog(null, "User Already Register with given Id","",JOptionPane.ERROR_MESSAGE);	 
	 }
  }
}
