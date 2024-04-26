
package DAO;

import BO.ProductBO;
import Domain.RentalPackage;
import Domain.User;
import Utility.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RentalPackageDAO {

	public RentalPackage findById(Integer id) throws SQLException, ClassNotFoundException {
        RentalPackage rentalPackage = null ;
        Connection connection = DBConnection.getConnection();
        
        //fill your code here
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM rental_package WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                rentalPackage = new RentalPackage();
                rentalPackage.setId(resultSet.getInt("id"));
                rentalPackage.setName(resultSet.getString("name"));
                rentalPackage.setIsVisible(resultSet.getBoolean("is_visible"));
                rentalPackage.setIsAvailable(resultSet.getBoolean("is_available"));
                rentalPackage.setCreatedDate(resultSet.getDate("created_date"));
                rentalPackage.setCity(resultSet.getString("city"));
                rentalPackage.setImageUrl(resultSet.getString("image_url"));
            }
        } finally {
           
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            connection.close();
        }
        return rentalPackage;
	}
	 public List<RentalPackage> getAvailableRentalPackages(String city) throws SQLException, ClassNotFoundException {
	        List<RentalPackage> packageList = new ArrayList<RentalPackage>();
	        Connection connection = DBConnection.getConnection();
	      

              //fill your code here
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        try {
	            String query = "SELECT * FROM rental_package WHERE is_available = 1 AND city = ?";
	            statement = connection.prepareStatement(query);
	            statement.setString(1, city);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                RentalPackage rentalPackage = new RentalPackage();
	                rentalPackage.setId(resultSet.getInt("id"));
	                rentalPackage.setName(resultSet.getString("name"));
	                rentalPackage.setIsVisible(resultSet.getBoolean("is_visible"));
	                rentalPackage.setIsAvailable(resultSet.getBoolean("is_available"));
	                rentalPackage.setCreatedDate(resultSet.getDate("created_date"));
	                rentalPackage.setCity(resultSet.getString("city"));
	                rentalPackage.setImageUrl(resultSet.getString("image_url"));
	                packageList.add(rentalPackage);
	            }
	        } finally {
	           
	            if (statement != null) {
	                statement.close();
	            }
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            connection.close();
	        }
	        return packageList;
    }
	 public List<RentalPackage> obtainAllPackages(boolean visibility,boolean availability) throws SQLException, ClassNotFoundException {
	        List<RentalPackage> packageList = new ArrayList<RentalPackage>();
	        Connection connection = DBConnection.getConnection();
	       
               //fill your code here
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        try {
	            String query = "SELECT * FROM rental_package WHERE is_visible = ? AND is_available = ?";
	            statement = connection.prepareStatement(query);
	            statement.setBoolean(1, visibility);
	            statement.setBoolean(2, availability);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                RentalPackage rentalPackage = new RentalPackage();
	                rentalPackage.setId(resultSet.getInt("id"));
	                rentalPackage.setName(resultSet.getString("name"));
	                rentalPackage.setIsVisible(resultSet.getBoolean("is_visible"));
	                rentalPackage.setIsAvailable(resultSet.getBoolean("is_available"));
	                rentalPackage.setCreatedDate(resultSet.getDate("created_date"));
	                rentalPackage.setCity(resultSet.getString("city"));
	                rentalPackage.setImageUrl(resultSet.getString("image_url"));
	                packageList.add(rentalPackage);
	            }
	        } finally {
	           
	            if (statement != null) {
	                statement.close();
	            }
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            connection.close();
	        }
	        return packageList;
 }
	 public List<RentalPackage> obtainAllPackagesForManager() throws SQLException, ClassNotFoundException {
	        List<RentalPackage> packageList = new ArrayList<RentalPackage>();
	        Connection connection = DBConnection.getConnection();
	       
               //fill your code here
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            String query = "SELECT * FROM rental_package";
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	                RentalPackage rentalPackage = new RentalPackage();
	                rentalPackage.setId(resultSet.getInt("id"));
	                rentalPackage.setName(resultSet.getString("name"));
	                rentalPackage.setIsVisible(resultSet.getBoolean("is_visible"));
	                rentalPackage.setIsAvailable(resultSet.getBoolean("is_available"));
	                rentalPackage.setCreatedDate(resultSet.getDate("created_date"));
	                rentalPackage.setCity(resultSet.getString("city"));
	                rentalPackage.setImageUrl(resultSet.getString("image_url"));
	                packageList.add(rentalPackage);
	            }
	        } finally {
	           
	            if (statement != null) {
	                statement.close();
	            }
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            connection.close();
	        }
	        return packageList;
}
    public List<RentalPackage> getRentalPackagesByOrder(Integer orderDetailId) throws SQLException, ClassNotFoundException {
        List<RentalPackage> packageList = new ArrayList<RentalPackage>();
        Connection connection = DBConnection.getConnection();
        
        //fill your code here
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT rp.* FROM rental_package rp " +
                           "JOIN order_details od ON rp.id = od.package_id " +
                           "WHERE od.order_detail_id = ?";
            statement = connection.prepareStatement(query);
            statement.setFloat(1, orderDetailId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RentalPackage rentalPackage = new RentalPackage();
                rentalPackage.setId(resultSet.getInt("id"));
                rentalPackage.setName(resultSet.getString("name"));
                rentalPackage.setIsVisible(resultSet.getBoolean("is_visible"));
                rentalPackage.setIsAvailable(resultSet.getBoolean("is_available"));
                rentalPackage.setCreatedDate(resultSet.getDate("created_date"));
                rentalPackage.setCity(resultSet.getString("city"));
                rentalPackage.setImageUrl(resultSet.getString("image_url"));
                packageList.add(rentalPackage);
            }
        } finally {
          
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            connection.close();
        }
        return packageList;
    }
    public void updateVisibility(RentalPackage pack) throws SQLException, ClassNotFoundException{
    	
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update rental_package set is_visible="+pack.getIsVisible()+" where id = "+pack.getId()+"");
		con.close();
	}
    
}
