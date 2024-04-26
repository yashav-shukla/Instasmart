

import java.io.IOException;
import java.util.Date;

import BO.RentalAgreementBO;
import Domain.Company;
import Domain.Discount;
import Domain.OrderDetail;
import Domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RentalAgreement
 */
@WebServlet("/RentalAgreement")
public class RentalAgreement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentalAgreement() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fill your code here
		// Retrieve form data
	    String agreementNumber = request.getParameter("agreementNumber");
	    // Similarly, retrieve other form fields like tenure, dates, etc.

	    // Assuming you have methods to retrieve company, order detail, discount, and total cost from the request
	    Company company = getCompanyFromRequest(request);
	    OrderDetail orderDetail = getOrderDetailFromRequest(request);
	    Discount discount = getDiscountFromRequest(request);
	    int totalCost = getTotalCostFromRequest(request);

	    // Create a new RentalAgreement object with the retrieved data
	    RentalAgreement rentalAgreement = new RentalAgreement();
	    rentalAgreement.setAgreementNumber(agreementNumber);
	    rentalAgreement.setCompany(company);
	    rentalAgreement.setOrderDetail(orderDetail);
	    rentalAgreement.setDiscount(discount);
	    rentalAgreement.setTotalCost(totalCost);

	    try {
	        // Create a new instance of RentalAgreementBO
	        RentalAgreementBO rentalAgreementBO = new RentalAgreementBO();
	        
	        // Save the rental agreement using the business object
	        RentalAgreement savedAgreement = rentalAgreementBO.save(rentalAgreement);

	        // Assuming successful save, redirect the user to a success page
	        response.sendRedirect("rentalAgreementSuccess.jsp");
	    } catch (SQLException | ClassNotFoundException e) {
	        // Handle exceptions appropriately, for example, show an error page
	        e.printStackTrace();
	        response.sendRedirect("error.jsp");
	    }

	}

	private void setTotalCost(int totalCost) {
		// TODO Auto-generated method stub
		
	}



	private void setDiscount(Discount discount) {
		// TODO Auto-generated method stub
		
	}



	private void setOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}



	private void setAgreementNumber(String agreementNumber) {
		// TODO Auto-generated method stub
		
	}



	private void setCompany(Company company) {
		// TODO Auto-generated method stub
		
	}



	private int getTotalCostFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}



	private Discount getDiscountFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}



	private OrderDetail getOrderDetailFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}



	private Company getCompanyFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
