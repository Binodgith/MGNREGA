package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
	public static Connection ProvideConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection con=null;
		
		String url="jdbc:mysql://localhost:3306/project_mgnrega";	
		try {
			con=DriverManager.getConnection(url,"root","root");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return con;
	}

}
