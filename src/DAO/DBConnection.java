package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.*;

public class DBConnection {
	private static Connection con;
	public  static Connection getConnection() {        
		try {
			if(con==null) {
				//driver class road 
				Class.forName("com.mysql.jdbc.Driver");
				//create connection ....
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instamart","root","945068");
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return con;
    }
}