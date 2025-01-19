import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class UpdateDatabaseRecords 
{
	public static void update(String productID,String productName,String company,String quantity,String priceperunit) 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				
 
	   

	    int pID=Integer.parseInt(productID);



	   	   
		String selectquery = "update productdetails set pName=?,pcompany=?,pquantity=?,ppriceperunit=? where pID=?";

		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(selectquery);
		


		pstmt.setString(1, productName);
		
		pstmt.setString(2,company);
		
		pstmt.setString(3,quantity);
		
		pstmt.setString(4,priceperunit);
		
		pstmt.setString(5,productID);
		
		


				
		int count = pstmt.executeUpdate();
		
		if(count==0)
		{
   		   System.out.println("No Recored Found with ID= "+pID);
		  JOptionPane.showMessageDialog(null," No Record Found !!!");
		}
		else
		{
			System.out.println("Record Id "+pID+ " Data Successfully Updated !!!");
		   JOptionPane.showMessageDialog(null," Data Successfully Updated !!!");
		}
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
  }
}
