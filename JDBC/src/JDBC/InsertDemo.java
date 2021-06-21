package JDBC;
import java.sql.*; 

public class InsertDemo 
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
			System.out.println("Connected database successfully..."); 
			//STEP 3: Execute a query 
			
			stmt = conn.createStatement();  
			String sql = "INSERT INTO Student VALUES (100, 'Zara', 'Ali', 18)"; 

			stmt.executeUpdate(sql); 
			sql = "INSERT INTO Student VALUES (101, 'Mahnaz', 'Fatma', 25)";  

			stmt.executeUpdate(sql); 
			sql = "INSERT INTO Student VALUES (102, 'Zaid', 'Khan', 30)"; 

			stmt.executeUpdate(sql); 
			sql = "INSERT INTO Student VALUES(103, 'Sumit', 'Mittal', 28)"; 

			stmt.executeUpdate(sql); 
			System.out.println("Inserted records into the table..."); 

		
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
 