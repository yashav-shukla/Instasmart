package DAO;

import BO.CatalogServiceSectorBO;
import Domain.Brand;
import Domain.CatalogServiceArea;
import Domain.CatalogServiceSector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utility.DBConnection;

public class CatalogServiceAreaDAO {
    public CatalogServiceArea obtainCatalogServiceAreaById(Integer id) throws ClassNotFoundException, SQLException{
        CatalogServiceArea csa = new CatalogServiceArea();
        Connection connection = DBConnection.getConnection();
        
        //fill your code here
        String query = "SELECT * FROM catalog_service_area WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            csa = new CatalogServiceArea();
            csa.setId(rs.getInt("id"));
            csa.setCategory(rs.getString("category"));
            // Assuming you have a method to obtain the associated sector from the database
            CatalogServiceSectorDAO sectorDAO = new CatalogServiceSectorDAO();
            CatalogServiceSector sector = sectorDAO.obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            csa.setCatalogServiceSector(sector);
        }
        rs.close();
        ps.close();
        connection.close();
        return csa;

    }
    public CatalogServiceArea obtainCatalogServiceAreaByCategory(String category) throws ClassNotFoundException, SQLException{
        CatalogServiceArea csa = new CatalogServiceArea();
        Connection connection = DBConnection.getConnection();
       
        //fill your code here
        String query = "SELECT * FROM catalog_service_area WHERE category = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, category);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            csa = new CatalogServiceArea();
            csa.setId(rs.getInt("id"));
            csa.setCategory(rs.getString("category"));
            // Assuming you have a method to obtain the associated sector from the database
            CatalogServiceSectorDAO sectorDAO = new CatalogServiceSectorDAO();
            CatalogServiceSector sector = sectorDAO.obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            csa.setCatalogServiceSector(sector);
        }
        rs.close();
        ps.close();
        connection.close();

        return csa;
    }
    public List<CatalogServiceArea> listServiceArea(CatalogServiceSector serviceSector) throws ClassNotFoundException, SQLException{
		List<CatalogServiceArea> serviceAreas = new ArrayList<CatalogServiceArea>();
		Connection con = DBConnection.getConnection();
		
                //fill your code here
		String query = "SELECT * FROM catalog_service_area WHERE catalog_service_sector_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, serviceSector.getId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            CatalogServiceArea csa = new CatalogServiceArea();
            csa.setId(rs.getInt("id"));
            csa.setCategory(rs.getString("category"));
            csa.setCatalogServiceSector(serviceSector);
            serviceAreas.add(csa);
        }
        rs.close();
        ps.close();
        con.close();

		return serviceAreas;
	}
    public List<CatalogServiceArea> obtainCatalogServiceList() throws ClassNotFoundException, SQLException{
		List<CatalogServiceArea> serviceAreas = new ArrayList<CatalogServiceArea>();
		Connection con = DBConnection.getConnection();
		
                //fill your code here
		String query = "SELECT * FROM catalog_service_area";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            CatalogServiceArea csa = new CatalogServiceArea();
            csa.setId(rs.getInt("id"));
            csa.setCategory(rs.getString("category"));
            // Assuming you have a method to obtain the associated sector from the database
            CatalogServiceSectorDAO sectorDAO = new CatalogServiceSectorDAO();
            CatalogServiceSector sector = sectorDAO.obtainCatalogServiceSectorById(rs.getInt("catalog_service_sector_id"));
            csa.setCatalogServiceSector(sector);
            serviceAreas.add(csa);
        }
        rs.close();
        ps.close();
        con.close();
		return serviceAreas;
	}
 
}
