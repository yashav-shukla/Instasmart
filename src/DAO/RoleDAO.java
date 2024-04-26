package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import Utility.DBConnection;
import Domain.Role;

public class RoleDAO {

	public Role findRoleById(Integer roleId) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		//file your code here.
		// Define the SQL query to find the role by its ID
        String query = "SELECT * FROM role WHERE id = ?";
        Role role = null;
        try {
            // Prepare the statement with the query and the roleId
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, roleId);
            
            // Execute the query and obtain the result set
            ResultSet rs = stmt.executeQuery();
            
            // Process the result set
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean active = rs.getBoolean("active");
                
                // Create a new Role object
                role = new Role(id, name, active);
            }
            
            // Close resources
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            // Close the connection
            con.close();
        }
        
        return role;
		
	}
	public Role getCustomerRole() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		
               //fill your code here
		String query = "SELECT * FROM role WHERE name = 'Customer'";
        Role role = null;
        try {
            // Prepare the statement with the query
            PreparedStatement stmt = con.prepareStatement(query);
            
            // Execute the query and obtain the result set
            ResultSet rs = stmt.executeQuery();
            
            // Process the result set
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean active = rs.getBoolean("active");
                
                // Create a new Role object
                role = new Role(id, name, active);
            }
            
            // Close resources
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            // Close the connection
            con.close();
        }
        
        return role;
		
	}
}
