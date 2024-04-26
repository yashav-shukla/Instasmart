package BO;

import java.sql.SQLException;
import java.util.Map;
import DAO.RentalPackageRateDAO;

public class RentalPackageRateBO {
      
    public Map<Integer,Integer> findPackageRate() throws ClassNotFoundException, SQLException{
        RentalPackageRateDAO rentalPackageRateDAO = new RentalPackageRateDAO();
        return rentalPackageRateDAO.findPackageRate();
    }
}
