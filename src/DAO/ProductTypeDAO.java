package DAO;

import BO.ProductCategoryBO;
import Domain.ProductCategory;
import Domain.ProductType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utility.DBConnection;

public class ProductTypeDAO {
    public ProductType obtainProductTypeById(Integer id) throws ClassNotFoundException, SQLException{
        ProductType productType = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
 String query = "SELECT * FROM product_type WHERE id = ?";
        
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            productType = new ProductType();
            productType.setId(rs.getInt("id"));
            productType.setType(rs.getString("type"));
            // You may also set other attributes here if needed
        }
        
      
        pstmt.close();
        rs.close();
        connection.close();
        return productType;
    }
    public ProductType obtainProductTypeByType(String type) throws ClassNotFoundException, SQLException{
        ProductType productType = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
String query = "SELECT * FROM product_type WHERE type = ?";
        
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, type);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            productType = new ProductType();
            productType.setId(rs.getInt("id"));
            productType.setType(rs.getString("type"));
            // You may also set other attributes here if needed
        }
        
     
        pstmt.close();
        rs.close();
        connection.close();
        return productType;
    }
    public List<ProductType> listProductTypes(ProductCategory productCategory) throws ClassNotFoundException, SQLException{
		List<ProductType> productTypes = new ArrayList<ProductType>();
		Connection con = DBConnection.getConnection();
		
               //fill your code here
String query = "SELECT * FROM product_type WHERE product_category_id = ?";
        
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, productCategory.getId());
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            ProductType productType = new ProductType();
            productType.setId(rs.getInt("id"));
            productType.setType(rs.getString("type"));
            // You may also set other attributes here if needed
            productTypes.add(productType);
        }
        
    
        pstmt.close();
        rs.close();
        con.close();
		return productTypes;
	}
    
    
    public List<ProductType> obtainAllProductType() throws ClassNotFoundException, SQLException{
        List<ProductType> productTypes = new ArrayList<ProductType>();
        Connection con = DBConnection.getConnection();
      
        //fill your code here
 String query = "SELECT * FROM product_type";
        
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            ProductType productType = new ProductType();
            productType.setId(rs.getInt("id"));
            productType.setType(rs.getString("type"));
            // You may also set other attributes here if needed
            productTypes.add(productType);
        }
        
      
        pstmt.close();
        rs.close();
        con.close();
        return productTypes;
    }
}
