package DAO;

import Domain.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utility.DBConnection;


public class MaterialDAO {
    public Material obtainMaterialById(Integer id) throws ClassNotFoundException, SQLException{
        Material material = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        String query = "SELECT * FROM material WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            material = new Material();
            material.setId(rs.getInt("id"));
            material.setName(rs.getString("name"));
        }

        rs.close();
        ps.close();
        connection.close();
        return material;
    }
    public Material obtainMaterialByName(String name) throws ClassNotFoundException, SQLException{
        Material material = null;
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        String query = "SELECT * FROM material WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            material = new Material();
            material.setId(rs.getInt("id"));
            material.setName(rs.getString("name"));
        }

        rs.close();
        ps.close();
        connection.close();
        return material;
    }
    public List<Material> listMaterials() throws ClassNotFoundException, SQLException{
		List<Material> materials = new ArrayList<Material>();
		Connection con = DBConnection.getConnection();
		
               //fill your code here
		String query = "SELECT * FROM material";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Material material = new Material();
            material.setId(rs.getInt("id"));
            material.setName(rs.getString("name"));
            materials.add(material);
        }

        rs.close();
        ps.close();
        con.close();
		return materials;
	}
}
