package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utility.DBConnection;
import Domain.RentalAgreement;

public class RentalAgreementDAO {
	public RentalAgreement save(RentalAgreement rentalAgreement) throws SQLException, ClassNotFoundException{
		Connection con = DBConnection.getConnection();
		
               //fill your code here
		PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Prepare the SQL statement to insert data into the rental_agreement table
            String sql = "INSERT INTO rental_agreement (order_detail_id, agreement_number, company_id, tenure, "
                         + "booked_date, delivery_date, renewal_date, expiry_date, discount_id, total_cost) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Set the parameters for the prepared statement
            ps.setLong(1, rentalAgreement.getOrderDetail().getId());
            ps.setString(2, rentalAgreement.getAgreementNumber());
            ps.setInt(3, rentalAgreement.getCompany().getId());
            ps.setInt(4, rentalAgreement.getTenure());
            ps.setDate(5, new java.sql.Date(rentalAgreement.getBookedDate().getTime()));
            ps.setDate(6, new java.sql.Date(rentalAgreement.getDeliveryDate().getTime()));
            ps.setDate(7, new java.sql.Date(rentalAgreement.getRenewalDate().getTime()));
            ps.setDate(8, new java.sql.Date(rentalAgreement.getExpiryDate().getTime()));
            ps.setInt(9, rentalAgreement.getDiscount().getId());
            ps.setInt(10, rentalAgreement.getTotalCost());

            // Execute the SQL statement
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating rental agreement failed, no rows affected.");
            }

            // Retrieve the auto-generated keys (if any)
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                // Set the ID of the rental agreement object with the auto-generated ID
                rentalAgreement.setId(rs.getLong(1));
            } else {
                throw new SQLException("Creating rental agreement failed, no ID obtained.");
            }
        } finally {
            // Close resources in a finally block to ensure they are always closed
           
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        }
		return rentalAgreement;
		
	}
	
}
