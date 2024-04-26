package DAO;

import Domain.Brand;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    public Brand obtainBrandById(Integer id) throws ClassNotFoundException, SQLException{
        Brand brand = null;
        Connection connection = DBConnection.getConnection();
       
       //fill your coe here
        String query = "SELECT * FROM brand WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            brand = new Brand();
            brand.setId(rs.getInt("id"));
            brand.setName(rs.getString("name"));
        }
        rs.close();
        ps.close();
        connection.close();
        return brand;

      
    }
    public Brand obtainBrandByName(String name) throws ClassNotFoundException, SQLException{
        Brand brand = null;
        Connection connection = DBConnection.getConnection();
       

       //fill your coe here

        String query = "SELECT * FROM brand WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            brand = new Brand();
            brand.setId(rs.getInt("id"));
            brand.setName(rs.getString("name"));
        }
        rs.close();
        ps.close();
        connection.close();
        return brand;
      
    }
    public List<Brand> listBrands() throws ClassNotFoundException, SQLException{
		List<Brand> brandList = new ArrayList<Brand>();
		Connection con = DBConnection.getConnection();
		
               //fill your coe here
		String query = "SELECT * FROM brand";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Brand brand = new Brand();
            brand.setId(rs.getInt("id"));
            brand.setName(rs.getString("name"));
            brandList.add(brand);
        }
        rs.close();
        ps.close();
        con.close();
        return brandList;
		
	}
}
