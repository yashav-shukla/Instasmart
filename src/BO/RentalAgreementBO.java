package BO;

import java.sql.SQLException;
import DAO.RentalAgreementDAO;
import Domain.RentalAgreement;

public class RentalAgreementBO {
	public RentalAgreement save(RentalAgreement rentalAgreement) throws SQLException, ClassNotFoundException{
		return new RentalAgreementDAO().save(rentalAgreement);
	}
	
	
	
}
