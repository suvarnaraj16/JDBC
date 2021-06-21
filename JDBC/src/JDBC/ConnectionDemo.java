package JDBC;
import java.sql.*;

public class ConnectionDemo {
	static final String driverName = "org.h2.Driver";
	static final String uname = "Suvarna Raj Yesupogu";
	static final String pass = "Su@arna4";
	static final String url = "jdbc:h2:~/test";
	public static void main(String args[]) throws SQLException {
		
		Connection con = null;
		Statement st = null;
		try {
			// Step 1 : Registering the JDBC Database Driver
			Class.forName(driverName);
			
			//Step 2 : Get the Connection
			con = DriverManager.getConnection(url,uname,pass);
			
			// Step 3 : Creating a Statement
			st = con.createStatement();
			
			// Step 4 : Executing the Statement
			String sql = "select * from Registration";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String first = rs.getString("first");
				String last = rs.getString("last");
				int age = rs.getInt("age");

				System.out.println("ID is : " + id + "\tFirst Name is : " + first + "\tLast Name is : " + last + "\tAge is : "+age);
				
			}
			
			
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally 
		{
			con.close();
			st.close();
		}
		
	}

}
