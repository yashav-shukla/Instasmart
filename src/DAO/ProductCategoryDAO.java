package DAO;

import BO.CatalogServiceAreaBO;
import Domain.CatalogServiceArea;
import Domain.ProductCategory;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDAO {
    public ProductCategory obtainProductCategoryById(Integer id) throws ClassNotFoundException, SQLException{
        ProductCategory productCategory = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        String query = "SELECT * FROM product_category WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            productCategory = new ProductCategory();
            productCategory.setId(resultSet.getInt("id"));
            productCategory.setCategory(resultSet.getString("category"));
            // Assuming you have a method to fetch CatalogServiceArea object by id
            CatalogServiceAreaBO serviceAreaBO = new CatalogServiceAreaBO();
            CatalogServiceArea serviceArea = serviceAreaBO.obtainCatalogServiceAreaById(resultSet.getInt("catalog_service_area_id"));
            productCategory.setCatalogServiceArea(serviceArea);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return productCategory;
    }
    public ProductCategory obtainProductCategoryByCategory(String category) throws ClassNotFoundException, SQLException{
        ProductCategory productCategory = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        String query = "SELECT * FROM product_category WHERE category = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, category);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            productCategory = new ProductCategory();
            productCategory.setId(resultSet.getInt("id"));
            productCategory.setCategory(resultSet.getString("category"));
            // Assuming you have a method to fetch CatalogServiceArea object by id
            CatalogServiceAreaBO serviceAreaBO = new CatalogServiceAreaBO();
            CatalogServiceArea serviceArea = serviceAreaBO.obtainCatalogServiceAreaById(resultSet.getInt("catalog_service_area_id"));
            productCategory.setCatalogServiceArea(serviceArea);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return productCategory;
    }
    public List<ProductCategory> listAllProductCategories()throws ClassNotFoundException, SQLException{
    	List<ProductCategory> productCategories = new ArrayList();
        Connection connection = DBConnection.getConnection();
        
        //fill your code here
        String query = "SELECT * FROM product_category";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setId(resultSet.getInt("id"));
            productCategory.setCategory(resultSet.getString("category"));
            // Assuming you have a method to fetch CatalogServiceArea object by id
            CatalogServiceAreaBO serviceAreaBO = new CatalogServiceAreaBO();
            CatalogServiceArea serviceArea = serviceAreaBO.obtainCatalogServiceAreaById(resultSet.getInt("catalog_service_area_id"));
            productCategory.setCatalogServiceArea(serviceArea);
            productCategories.add(productCategory);
        }
        resultSet.close();
        statement.close();
        connection.close();
    	return productCategories;
    }
    public List<ProductCategory> listProductCategory(CatalogServiceArea serviceArea) throws ClassNotFoundException, SQLException{
		List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
		Connection con = DBConnection.getConnection();
		
               //fill your code here
		String query = "SELECT * FROM product_category WHERE catalog_service_area_id = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, serviceArea.getId());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setId(resultSet.getInt("id"));
            productCategory.setCategory(resultSet.getString("category"));
            productCategory.setCatalogServiceArea(serviceArea);
            productCategories.add(productCategory);
        }
        resultSet.close();
        statement.close();
        con.close();
		return productCategories;
	}
}
