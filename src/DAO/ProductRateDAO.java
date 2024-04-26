package DAO;

import Domain.Product;
import Domain.ProductRate;

import java.sql.Connection;
import Utility.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductRateDAO {
    public ProductRate obtainProductRateById(Product product) throws ClassNotFoundException, SQLException{
        ProductRate productRate = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        String query = "SELECT * FROM product_rate WHERE product_id = ? AND end_date IS NULL ORDER BY start_date DESC LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, product.getId());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            productRate = new ProductRate();
            productRate.setId(resultSet.getInt("id"));
            productRate.setEndDate(resultSet.getTimestamp("end_date"));
            productRate.setRate(resultSet.getInt("rate"));
            productRate.setStartDate(resultSet.getTimestamp("start_date"));
            // Assuming you have setters in the ProductRate class
        }
        connection.close();
        return productRate;
    }
    public ProductRate createProductRate(ProductRate rate) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into product_rate(product_id,rate,start_date) values(?,?,?)");
		
               //fill your code here
        ps.setInt(1, rate.getProduct_id());
        ps.setLong(2, rate.getRate());
        ps.setTimestamp(3, new Timestamp(System.currentTimeMillis())); // Assuming the start date is the current timestamp
        ps.executeUpdate();
        con.close();
		return rate;
	}
}
