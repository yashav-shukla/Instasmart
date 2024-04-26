
package DAO;

import BO.*;
import Domain.*;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BO.BrandBO;
import BO.CatalogServiceAreaBO;
import BO.CatalogServiceSectorBO;
import BO.MaterialBO;
import BO.ProductCategoryBO;
import BO.ProductTypeBO;
import Domain.Brand;
import Domain.CatalogServiceArea;
import Domain.CatalogServiceSector;
import Domain.Material;
import Domain.Product;
import Domain.ProductCategory;
import Domain.ProductType;

public class ProductDAO {
	public Product findById(Integer id) throws ClassNotFoundException, SQLException{
		Connection connection = DBConnection.getConnection();
	    PreparedStatement ps = connection.prepareStatement("select * from product where id = ?");
	   
          //fill your code here
	    //mycode is open---------------------------
	    ps.setInt(1, id); // Set the ID parameter in the query
	    ResultSet rs = ps.executeQuery();
	    Product product = null;
	    if (rs.next()) {
	        // Create a Product object using the data from the result set
	        Brand brand = new BrandBO().obtainBrandById(rs.getInt("brand_id"));
	        ProductType productType = new ProductTypeBO().obtainProductTypeById(rs.getInt("product_type_id"));
	        ProductCategory productCategory = new ProductCategoryBO().obtainProductCategoryById(rs.getInt("product_category_id"));
	        CatalogServiceSector css = new CatalogServiceSectorBO().obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
	        CatalogServiceArea csa = new CatalogServiceAreaBO().obtainCatalogServiceAreaById(rs.getInt("catalog_service_area_id"));
	        Material material = new MaterialBO().obtainMaterialById(rs.getInt("material_id"));

	        product = new Product(
	                rs.getInt("id"),
	                rs.getString("name"),
	                brand,
	                productType,
	                productCategory,
	                css,
	                csa,
	                rs.getString("color"),
	                material,
	                rs.getString("dimensions"),
	                rs.getBoolean("is_visible"),
	                rs.getBoolean("is_available"),
	                rs.getString("city"),
	                rs.getString("image_url")
	            );
	            ProductRate productRate = new ProductRateBO().obtainProductRateByProduct(product);
	        }
	    rs.close();
	    ps.close();
	    connection.close();
	    return product;
	    //mycode is closed----------------------------
	}
	

    
    public List<Product> obtainAvailableProduct(String city) throws ClassNotFoundException, SQLException{
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        //mycode is open-----------------------------------------
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM product WHERE city = ? AND is_available = TRUE");
        ps.setString(1, city);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            // Create a Product object using the data from the result set
            Brand brand = new BrandBO().obtainBrandById(rs.getInt("brand_id"));
            ProductType productType = new ProductTypeBO().obtainProductTypeById(rs.getInt("product_type_id"));
            ProductCategory productCategory = new ProductCategoryBO().obtainProductCategoryById(rs.getInt("product_category_id"));
            CatalogServiceSector css = new CatalogServiceSectorBO().obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            CatalogServiceArea csa = new CatalogServiceAreaBO().obtainCatalogServiceAreaById(rs.getInt("catalog_service_area_id"));
            Material material = new MaterialBO().obtainMaterialById(rs.getInt("material_id"));

            Product product = new Product(
                rs.getInt("id"),
                rs.getString("name"),
                brand,
                productType,
                productCategory,
                css,
                csa,
                rs.getString("color"),
                material,
                rs.getString("dimensions"),
                rs.getBoolean("is_visible"),
                rs.getBoolean("is_available"),
                rs.getString("city"),
                rs.getString("image_url")
            );
            ProductRate productRate = new ProductRateBO().obtainProductRateByProduct(product);
            productList.add(product);
        }

        rs.close();
        ps.close();
        connection.close();
        return productList;
        //mycode is closed-------------------------
    }
    
    
    
    
    public List<Product> obtainAllProducts(boolean visibilty,boolean availability) throws ClassNotFoundException, SQLException{
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        //mycode is open----------------------------
        String sql = "SELECT * FROM product WHERE is_visible = ? AND is_available = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
     // Set the query parameters
        ps.setBoolean(1, visibilty);
        ps.setBoolean(2, availability);
     // Execute the query
        ResultSet rs = ps.executeQuery();
     // Iterate through the result set and create Product objects
        while (rs.next()) {
            // Fetch the necessary data from the result set
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Brand brand = new BrandBO().obtainBrandById(rs.getInt("brand_id"));
            ProductType productType = new ProductTypeBO().obtainProductTypeById(rs.getInt("product_type_id"));
            ProductCategory productCategory = new ProductCategoryBO().obtainProductCategoryById(rs.getInt("product_category_id"));
            CatalogServiceSector css = new CatalogServiceSectorBO().obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            CatalogServiceArea csa = new CatalogServiceAreaBO().obtainCatalogServiceAreaById(rs.getInt("catalog_service_area_id"));
            Material material = new MaterialBO().obtainMaterialById(rs.getInt("material_id"));
            String color = rs.getString("color");
            String dimensions = rs.getString("dimensions");
            String city = rs.getString("city");
            String imageUrl = rs.getString("image_url");
            
            // Create a new Product object with the fetched data
            Product product = new Product(id, name, brand, productType, productCategory, css, csa, color, material, dimensions, visibilty, availability, city, imageUrl);
            // Add the product to the list
            productList.add(product);
        }
     // Close the result set and prepared statement
        rs.close();
        ps.close();
        connection.close();
        return productList;
        //mycode is closed---------------------------------------------------
    }
    
    
    
    
    public List<Product> obtainAllProductsForManager() throws ClassNotFoundException, SQLException{
        List<Product> productList = new ArrayList<Product>();
        System.out.println("connection before db");
        Connection connection = DBConnection.getConnection();
       System.out.println(connection);
        //fill your code here
        //mycode is open---------------------------
        String sql = "SELECT * FROM product";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        // Execute the query
        ResultSet rs = ps.executeQuery();
        
        // Iterate through the result set and create Product objects
        while (rs.next()) {
            // Fetch the necessary data from the result set
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Brand brand = new BrandBO().obtainBrandById(rs.getInt("brand_id"));
            ProductType productType = new ProductTypeBO().obtainProductTypeById(rs.getInt("product_type_id"));
            ProductCategory productCategory = new ProductCategoryBO().obtainProductCategoryById(rs.getInt("product_category_id"));
            CatalogServiceSector css = new CatalogServiceSectorBO().obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            CatalogServiceArea csa = new CatalogServiceAreaBO().obtainCatalogServiceAreaById(rs.getInt("catalog_service_area_id"));
            Material material = new MaterialBO().obtainMaterialById(rs.getInt("material_id"));
            String color = rs.getString("color");
            String dimensions = rs.getString("dimensions");
            boolean isVisible = rs.getBoolean("is_visible");
            boolean isAvailable = rs.getBoolean("is_available");
            String city = rs.getString("city");
            String imageUrl = rs.getString("image_url");
            
            // Create a new Product object with the fetched data
            Product product = new Product(id, name, brand, productType, productCategory, css, csa, color, material, dimensions, isVisible, isAvailable, city, imageUrl);
            
            // Add the product to the list
            productList.add(product);
        }
        
        // Close the result set and prepared statement
        rs.close();
        ps.close();
        
        // Close the connection
        connection.close();
        
        // Return the list of products
        return productList;
        //mycode is closed----------------------------------------------------------------
    }
    
    
    public List<Product> getProductsByOrder(Integer orderDetailId) throws ClassNotFoundException, SQLException {
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product inner join order_detail_product on product.id=order_detail_product.product_id where order_detail_product.order_detail_id="+orderDetailId+";");
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Brand brand = new BrandBO().obtainBrandById(rs.getInt("brand_id"));
            ProductType productType = new ProductTypeBO().obtainProductTypeById(rs.getInt("product_type_id"));
            ProductCategory productCategory = new ProductCategoryBO().obtainProductCategoryById(rs.getInt("product_category_id"));
            CatalogServiceSector css = new CatalogServiceSectorBO().obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            CatalogServiceArea csa = new CatalogServiceAreaBO().obtainCatalogServiceAreaById(rs.getInt("catalog_service_area_id"));
            Material material = new MaterialBO().obtainMaterialById(rs.getInt("material_id"));
            Product p=new Product(rs.getInt("id"), rs.getString("name"), brand, productType, productCategory, css, csa, rs.getString("color"), material, rs.getString("dimensions"), rs.getBoolean("is_visible"), rs.getBoolean("is_available"),rs.getString("city"),rs.getString("image_url"));
            ProductRate productRate = new ProductRateBO().obtainProductRateByProduct(p);
            productList.add(p);
        }
        connection.close();
        return productList;
    }

    public List<Product> getProductsByPackage(Integer packageId) throws ClassNotFoundException, SQLException {
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product inner join rental_package_product as pp on product.id=pp.product_id where pp.package_id="+packageId+";");
        ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            Brand brand = new BrandBO().obtainBrandById(rs.getInt("brand_id"));
            ProductType productType = new ProductTypeBO().obtainProductTypeById(rs.getInt("product_type_id"));
            ProductCategory productCategory = new ProductCategoryBO().obtainProductCategoryById(rs.getInt("product_category_id"));
            CatalogServiceSector css = new CatalogServiceSectorBO().obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            CatalogServiceArea csa = new CatalogServiceAreaBO().obtainCatalogServiceAreaById(rs.getInt("catalog_service_area_id"));
            Material material = new MaterialBO().obtainMaterialById(rs.getInt("material_id"));
            Product p=new Product(rs.getInt("id"), rs.getString("name"), brand, productType, productCategory, css, csa, rs.getString("color"), material, rs.getString("dimensions"), rs.getBoolean("is_visible"), rs.getBoolean("is_available"),rs.getString("city"),rs.getString("image_url"));
            ProductRate productRate = new ProductRateBO().obtainProductRateByProduct(p);
            productList.add(p);
        }
        connection.close();
        return productList;
    }
    public Product addProduct(Product p) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		
                //fill your code here
//mycode is open----------------------------------------------------
		// Prepare the SQL query to insert a new product
	    String sql = "INSERT INTO product (name, brand_id, product_type_id, product_category_id, catalog_service_sector_id, catalog_service_area_id, color, material_id, dimensions, is_visible, is_available, city, image_url) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	 // Set the parameters for the query based on the Product object
	    ps.setString(1, p.getName());
	    ps.setInt(2, p.getBrand().getId());
	    ps.setInt(3, p.getProductType().getId());
	    ps.setInt(4, p.getProductCategory().getId());
	    ps.setInt(5, p.getCatalogServiceSector().getId());
	    ps.setInt(6, p.getCatalogServiceArea().getId());
	    ps.setString(7, p.getColor());
	    ps.setInt(8, p.getMaterial().getId());
	    ps.setString(9, p.getDimensions());
	    ps.setBoolean(10, p.getIsVisible());
	    ps.setBoolean(11, p.getIsAvailable());
	    ps.setString(12, p.getCity());
	    ps.setString(13, p.getImageUrl());
	    
	    // Execute the insert query
	    ps.executeUpdate();
	    
	 // Retrieve the generated product ID
	    ResultSet rs = ps.getGeneratedKeys();
	    if (rs.next()) {
	        int productId = rs.getInt(1);
	        p.setId(productId);
	    }
	 // Close the ResultSet and PreparedStatement
	    rs.close();
	    ps.close();
	    
		con.close();
		return p;
	}
}
