

import java.io.IOException;
import java.sql.SQLException;

import BO.RentalPackageBO;
import Domain.RentalPackage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HidePackage
 */
@WebServlet("/HidePackage")
public class HidePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HidePackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Get the ID of the rental package to hide from the request parameter
String packageIdString = request.getParameter("packageId");
        
        // Check if packageId parameter is present
        if(packageIdString != null && !packageIdString.isEmpty()) {
            try {
                // Convert packageId to integer
                int packageId = Integer.parseInt(packageIdString);
                
                // Retrieve the rental package from the database or any storage mechanism
                RentalPackageBO rentalPackageBO = new RentalPackageBO();
                RentalPackage rentalPackage = null;
                try {
                    rentalPackage = rentalPackageBO.findById(packageId);
                } catch (ClassNotFoundException e1) {
                    // Handle ClassNotFoundException
                    e1.printStackTrace();
                } catch (SQLException e2) {
                    // Handle SQLException
                    e2.printStackTrace();
                }
                
                if (rentalPackage != null) {
                    // Set the isVisible flag to false to hide the package
                    rentalPackage.setIsVisible(false);
                    
                    try {
                        // Update the rental package visibility in the database or storage
                        rentalPackageBO.updateVisibility(rentalPackage);
                        // Package hidden successfully
                        response.getWriter().write("Rental package with ID " + packageId + " has been hidden.");
                    } catch (ClassNotFoundException | SQLException e) {
                        // Handle ClassNotFoundException or SQLException
                        e.printStackTrace();
                        // Failed to hide the package
                        response.getWriter().write("Failed to hide rental package with ID " + packageId + ".");
                    }
                } else {
                    // Rental package with given ID not found
                    response.getWriter().write("Rental package with ID " + packageId + " not found.");
                }
            } catch (NumberFormatException e) {
                // Invalid packageId parameter
                response.getWriter().write("Invalid package ID format.");
            }
        } else {
            // If packageId parameter is not provided
            response.getWriter().write("Please provide a package ID.");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
