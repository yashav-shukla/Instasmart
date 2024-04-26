package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Utility.DBConnection;
import Domain.Discount;


public class DiscountDAO {
	 public ArrayList<Discount> listAllDiscount() throws ClassNotFoundException, SQLException{
		 	ArrayList<Discount> discountList = new ArrayList<Discount>();
	        Connection connection = DBConnection.getConnection();
	        

               //fill your code here
	        String query = "SELECT * FROM discount";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Discount discount = new Discount();
	            discount.setId(rs.getInt("id"));
	            discount.setTenure(rs.getInt("tenure"));
	            discount.setPercentage(rs.getInt("percentage"));
	            discountList.add(discount);
	        }
	        rs.close();
	        ps.close();
	        connection.close();
	        return discountList;
	    }
	 
	 public Discount findById(Integer id) throws ClassNotFoundException, SQLException{
		 Discount discount = null;
		 	Connection connection = DBConnection.getConnection();
	       

               //fill your code here
		 	String query = "SELECT * FROM discount WHERE id = ?";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            discount = new Discount();
	            discount.setId(rs.getInt("id"));
	            discount.setTenure(rs.getInt("tenure"));
	            discount.setPercentage(rs.getInt("percentage"));
	        }
	        rs.close();
	        ps.close();
	        connection.close();

	        return discount;
	 }
}
