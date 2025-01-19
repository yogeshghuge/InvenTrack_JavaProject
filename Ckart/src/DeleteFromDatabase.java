import java.io.*;
import java.sql.*;

public class DeleteFromDatabase 
{
	public static void delete(String pid) 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				
 	  
	   
	    
	    int pID=Integer.parseInt(pid);
	   	   
	    String deleteQuery = "delete from productdetails where pID=?";
		PreparedStatement preparedStatement;
		
		preparedStatement = conn.prepareStatement(deleteQuery);
		preparedStatement.setString(1, pID+"");
			
		int count = preparedStatement.executeUpdate();
		
		if(count==0)		
   		   System.out.println("No Recored Found with ID= !!!"+pID);
		else
		   System.out.println(" Total "+count + " Records Deleted !!!");
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
  }
}
