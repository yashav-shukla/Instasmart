package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Utility.DBConnection;
import BO.UserBO;
import Domain.Address;

public class AddressDAO {
	
	public  Address findById(Integer id) throws ClassNotFoundException, SQLException{
		Address address = null;
		
		Connection con = DBConnection.getConnection();	
		//fill your code
		 String query = "SELECT * FROM address WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            address = new Address();
	            address.setId(rs.getInt("id"));
	            address.setUser(rs.getInt("user_id"));
	            address.setStreet(rs.getString("street"));
	            address.setCity(rs.getString("city"));
	            address.setState(rs.getString("state"));
	            address.setCountry(rs.getString("country"));
	            address.setPincode(rs.getInt("pincode"));
	        }
	        rs.close();
	        ps.close();
	        con.close();

		return address;		
	}
	
	public ArrayList<Address> findByUserId(Integer userId) throws ClassNotFoundException, SQLException{
		ArrayList<Address> addressList = new ArrayList<>();
		Connection con = DBConnection.getConnection();

		//fill you code here
		String query = "SELECT * FROM address WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Address address = new Address();
            address.setId(rs.getInt("id"));
            address.setUser(rs.getInt("user_id"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setCountry(rs.getString("country"));
            address.setPincode(rs.getInt("pincode"));
            addressList.add(address);
        }
        rs.close();
        ps.close();
        con.close();
		return addressList;		
	}
	
	public ArrayList<Address> findByUserId(Integer userId, String city) throws ClassNotFoundException, SQLException{
		ArrayList<Address> addressList = new ArrayList<>();
		Connection con =  DBConnection.getConnection();
		
               //fill your code here
		 String query = "SELECT * FROM address WHERE user_id = ? AND city = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, userId);
	        ps.setString(2, city);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Address address = new Address();
	            address.setId(rs.getInt("id"));
	            address.setUser(rs.getInt("user_id"));
	            address.setStreet(rs.getString("street"));
	            address.setCity(rs.getString("city"));
	            address.setState(rs.getString("state"));
	            address.setCountry(rs.getString("country"));
	            address.setPincode(rs.getInt("pincode"));
	            addressList.add(address);
	        }
	        rs.close();
	        ps.close();
	        con.close();
		return addressList;		
	}
	
	public Address create(Address address,Integer userId) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into address(user_id,street,city,state,country,pincode) values(?,?,?,?,?,?)");
		

                //fill your coe here
        ps.setInt(1, userId);
        ps.setString(2, address.getStreet());
        ps.setString(3, address.getCity());
        ps.setString(4, address.getState());
        ps.setString(5, address.getCountry());
        ps.setInt(6, address.getPincode());
        
        int rowsInserted = ps.executeUpdate();
        
        // If the insertion is successful, we may want to return the address object with updated information.
        if (rowsInserted > 0) {
            // Fetch the generated ID for the new address (if needed)
            String lastInsertedIdQuery = "SELECT LAST_INSERT_ID()";
            ResultSet rs = ps.executeQuery(lastInsertedIdQuery);
            
            if (rs.next()) {
                int id = rs.getInt(1);
                address.setId(id);
            }
            rs.close();
        }
        
        ps.close();
        con.close();
                  
		return address;
		
	}
//	public static void main(String[] args) {
//		try {			
//		Address add = new AddressDAO().findById(1);
//		System.out.println(add.getCity());
//		}
//		catch(Exception e) {
//			System.out.print(e.getMessage());
//		}
//	}

}
