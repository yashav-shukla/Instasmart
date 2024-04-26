package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BO.AddressBO;
import BO.RoleBO;
import Domain.Role;
import Domain.User;
//import Utility.DBConnection;
public class UserDAO {
	public synchronized User   validateLogin(String username,String password) throws ClassNotFoundException, SQLException{
		User user = null;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet rs = null;

	    try {
	        // Get connection from DBConnection utility class
	        connection = DBConnection.getConnection();
	        System.out.println("Database connected successfully");

	        // Prepare SQL query to retrieve user details based on username and password
	        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, password);

	        // Execute the query and retrieve the result set
	        rs = preparedStatement.executeQuery();

	        // Create instances of business objects (RoleBO and AddressBO)
	        RoleBO roleBO = new RoleBO();
	        AddressBO addressBO = new AddressBO();

	        // Check if a user with the given credentials exists
	        if (rs.next()) {
	            // Retrieve role information using RoleBO
	            Role role = roleBO.findRoleById(rs.getInt("role_id"));

	            // Create a new User object using the retrieved data
	            user = new User(
	                rs.getInt("id"),
	                rs.getString("first_name"),
	                rs.getString("last_name"),
	                rs.getDate("dob"),
	                rs.getInt("age"),
	                rs.getString("contact_no"),
	                rs.getString("email"),
	                rs.getString("username"),
	                rs.getString("password"),
	                role
	            );

	            // Set the user's address list using AddressBO
	            user.setAddressList(addressBO.findByUserId(user.getId()));
	        }
	    } finally {
	        // Close ResultSet, PreparedStatement, and Connection in a finally block
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace(); // Handle or log the exception
	            }
	        }
	        if (preparedStatement != null) {
	            try {
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace(); // Handle or log the exception
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace(); // Handle or log the exception
	            }
	        }
	    }

	    return user; 
    }
	
	public synchronized User findById(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

         //fill your code here	
		// my code open ------------------------------------------
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    User user = null;

	    try {
	        con = DBConnection.getConnection();
	        ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        RoleBO roleBO = new RoleBO();
	        AddressBO addressBO = new AddressBO();

	        if (rs.next()) {
	            Role role = roleBO.findRoleById(rs.getInt("role_id"));
	            user = new User(
	                rs.getInt("id"),
	                rs.getString("first_name"),
	                rs.getString("last_name"),
	                rs.getDate("dob"),
	                rs.getInt("age"),
	                rs.getString("contact_no"),
	                rs.getString("email"),
	                rs.getString("username"),
	                rs.getString("password"),
	                role
	            );
	            user.setAddressList(addressBO.findByUserId(user.getId()));
	        }
	    } finally {
	        // Close ResultSet, PreparedStatement, and Connection in a finally block
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                // Handle exception or log if needed
	                e.printStackTrace();
	            }
	        }
	        if (ps != null) {
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                // Handle exception or log if needed
	                e.printStackTrace();
	            }
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                // Handle exception or log if needed
	                e.printStackTrace();
	            }
	        }
	    }

	    return user;
		    //my code closed ---------------------------------------------------------------
	}
	public synchronized boolean findUserByUsername(String username) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select count(*) from user where username=?");
		
         //fill your code here
		//my code open--------------------------------------------------------
		 ps.setString(1, username);
		    ResultSet rs = ps.executeQuery();
		    
		    int count = 0;
		    if (rs.next()) {
		        count = rs.getInt(1);
		    }
		    
		    ps.close();
		    con.close();
		    return count > 0;		
	   //mycode closed ----------------------------------------------------------
	}
	public synchronized Integer createUser(User user) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		
        //fill your code here
//mycode open -------------------------------------------------------------------------
		 PreparedStatement ps = con.prepareStatement(
			        "INSERT INTO user (first_name, last_name, dob, age, contact_no, email, username, password, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
			        Statement.RETURN_GENERATED_KEYS
			    );
			    // Setting values to the prepared statement
			    ps.setString(1, user.getFirstName());
			    ps.setString(2, user.getLastName());
			    ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			    ps.setInt(4, user.getAge());
			    ps.setString(5, user.getContactNo());
			    ps.setString(6, user.getEmail());
			    ps.setString(7, user.getUsername());
			    ps.setString(8, user.getPassword());
			    ps.setInt(9, user.getRole().getId());
			    
			    ps.executeUpdate();
			    
			    // Retrieve the generated key (user ID)
			    ResultSet rs = ps.getGeneratedKeys();
			    Integer userId = null;
			    if (rs.next()) {
			        userId = rs.getInt(1);
			    }
			    
			    ps.close();
			    con.close();
			    
			    return userId;
	//mycode closed		---------------------------------------------------------------------------    
	}
	public synchronized void updateContactDetail(User user) throws SQLException, ClassNotFoundException{
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();


          //fill your code here
		// mycode open------------------------------------------------------------------------
		 PreparedStatement ps = con.prepareStatement("UPDATE user SET contact_no = ?, email = ? WHERE id = ?");
		    
		    ps.setString(1, user.getContactNo());
		    ps.setString(2, user.getEmail());
		    ps.setInt(3, user.getId());
		    
		    ps.executeUpdate();
		    
		    ps.close();
		    con.close();
		//mycode closed-------------------------------------------------------------------------------
	}
//code is this function by own -----------------------------------------------------------
	public synchronized void updateProfile(User user) throws SQLException, ClassNotFoundException{
		 // Prepare an SQL statement to update the user's profile
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();

	    PreparedStatement ps = con.prepareStatement(
	        "UPDATE user SET first_name = ?, last_name = ?, dob = ?, age = ?, contact_no = ?, email = ? WHERE id = ?"
	    );
	    
	    // Set the parameters in the prepared statement with the values from the user object
	    ps.setString(1, user.getFirstName());
	    ps.setString(2, user.getLastName());
	    ps.setDate(3, new java.sql.Date(user.getDob().getTime())); // Convert the java.util.Date to java.sql.Date
	    ps.setInt(4, user.getAge());
	    ps.setString(5, user.getContactNo());
	    ps.setString(6, user.getEmail());
	    ps.setInt(7, user.getId());
	    
	    // Execute the update query
	    ps.executeUpdate();
	    
	    // Close the resources
	    ps.close();
	    con.close();
	}
}
