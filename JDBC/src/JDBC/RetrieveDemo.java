package JDBC;
import java.sql.*;

public class RetrieveDemo 
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
			String sql = "SELECT id, first, last, age FROM Student"; 
			ResultSet rs = stmt.executeQuery(sql); 

			// STEP 4: Extract data from result set 
			while(rs.next()) { 
				// Retrieve by column name 
				int id  = rs.getInt("id"); 
				int age = rs.getInt("age"); 
				String first = rs.getString("first"); 
				String last = rs.getString("last");  

				// Display values 
				System.out.print("ID: " + id); 
				System.out.print(", Age: " + age); 
				System.out.print(", First: " + first); 
				System.out.println(", Last: " + last); 
			} 
			// STEP 5: Clean-up environment 
			rs.close(); 

		
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