package JDBC;
import java.sql.*;

public class CreateDemo 
{ 
	static final String drivername = "org.h2.Driver";   
	static final String url = "jdbc:h2:~/test";  
	static final String uname = "Suvarna Raj Yesupogu"; 
	static final String pass = "Su@arna4"; 

	public static void main(String[] args) 
	{ 
		Connection conn = null; 
		Statement stmt = null; 
		try { 
			// STEP 1: Register JDBC driver 
			Class.forName(drivername); 

			//STEP 2: Open a connection 
			System.out.println("Connecting to database..."); 
			conn = DriverManager.getConnection(url,uname,pass);  

			//STEP 3: Execute a query 
			System.out.println("Creating table in given database..."); 
			stmt = conn.createStatement(); 
			String sql =  "CREATE TABLE Student (id INTEGER not NULL,first VARCHAR(255), last VARCHAR(255), age INTEGER,PRIMARY KEY ( id ))";  
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database..."); 

			// STEP 4: Clean-up environment 
			stmt.close(); 
			conn.close(); 
		} 
		catch(SQLException se) 
		{ 
			se.printStackTrace(); 
		} 
		catch(Exception e) 
		{ 
			e.printStackTrace(); 
		} 
		finally 
		{ 
			try
			{ 
				if(stmt!=null) 
					stmt.close(); 
			} 
			catch(SQLException se2) 
			{ 
			}
			try 
			{ 
				if(conn!=null) conn.close(); 
			} 
			catch(SQLException se)
			{ 
				se.printStackTrace(); 
			} 
		} 
	}
}