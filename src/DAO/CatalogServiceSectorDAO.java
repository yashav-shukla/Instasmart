package DAO;

import Domain.CatalogServiceSector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utility.DBConnection;

public class CatalogServiceSectorDAO {
    public CatalogServiceSector obtainCatalogServiceSectorById(Integer id) throws ClassNotFoundException, SQLException{
        CatalogServiceSector catalogServiceSector = new CatalogServiceSector();
        Connection connection = DBConnection.getConnection();
       

        //fill your code here
        String query = "SELECT * FROM catalog_service_sector WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            catalogServiceSector = new CatalogServiceSector();
            catalogServiceSector.setId(rs.getInt("id"));
            catalogServiceSector.setName(rs.getString("name"));
        }
        rs.close();
        ps.close();
        connection.close();

        return catalogServiceSector;
    }
    public CatalogServiceSector obtainCatalogServiceSectorByName(String name) throws ClassNotFoundException, SQLException{
        CatalogServiceSector catalogServiceSector = new CatalogServiceSector();
        Connection connection = DBConnection.getConnection();


        //fill your code here       
        String query = "SELECT * FROM catalog_service_sector WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            catalogServiceSector = new CatalogServiceSector();
            catalogServiceSector.setId(rs.getInt("id"));
            catalogServiceSector.setName(rs.getString("name"));
        }
        rs.close();
        ps.close();
        connection.close();

        return catalogServiceSector;
    }
    public List<CatalogServiceSector> listServiceSector() throws ClassNotFoundException, SQLException{
		List<CatalogServiceSector> serviceSectors = new ArrayList<CatalogServiceSector>();
		Connection con = DBConnection.getConnection();
		
              //fill your code here
		String query = "SELECT * FROM catalog_service_sector";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            CatalogServiceSector catalogServiceSector = new CatalogServiceSector();
            catalogServiceSector.setId(rs.getInt("id"));
            catalogServiceSector.setName(rs.getString("name"));
            serviceSectors.add(catalogServiceSector);
        }
        rs.close();
        ps.close();
        con.close();

		return serviceSectors;
	}
}
