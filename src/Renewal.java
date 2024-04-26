

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import BO.OrderDetailBO;
import BO.ProductRateBO;
import BO.RentalAgreementBO;
import Domain.OrderDetail;
import Domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Renewal
 */
@WebServlet("/Renewal")
public class Renewal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Renewal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Retrieve order detail ID from request
        String orderIdStr = request.getParameter("order_id");
        
        // Check if orderIdStr is not null and not empty
        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                // Parse order detail ID from the request
                long orderId = Long.parseLong(orderIdStr);
                
                // Create an instance of OrderDetailBO to perform renewal
                OrderDetailBO orderDetailBO = new OrderDetailBO();
                
                // Retrieve the order detail using the ID
                OrderDetail order = orderDetailBO.getOrderDetailById(orderId);
                
                // Check if order is not null
                if (order != null) {
                    // Perform renewal operation
                    boolean renewalSuccess = orderDetailBO.renewOrder(order);
                    
                    // Check if renewal was successful
                    if (renewalSuccess) {
                        // Renewal successful
                        response.getWriter().write("Order renewal successful!");
                    } else {
                        // Renewal failed
                        response.getWriter().write("Order renewal failed. Please try again later.");
                    }
                } else {
                    // Order not found
                    response.getWriter().write("Order not found with ID: " + orderId);
                }
            } catch (NumberFormatException e) {
                // Invalid order ID format
                response.getWriter().write("Invalid order ID format.");
            } catch (SQLException e) {
                // Database error
                response.getWriter().write("Error accessing database.");
                e.printStackTrace(); // Print stack trace for debugging
            }
        } else {
            // Order ID parameter not provided
            response.getWriter().write("Order ID parameter not provided.");
        }
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
