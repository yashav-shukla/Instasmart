
import java.io.IOException;
import BO.ProductBO;
import Domain.Product;
import Domain.ProductRate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/CreateProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String name=(String)request.getParameter("name");
		String color=(String)request.getParameter("colors");
		String dimensions=(String)request.getParameter("dimensions");
		String city=(String)request.getParameter("city");
		String b=(String)request.getParameter("brand");
		String m=(String)request.getParameter("material");
		String css=(String)request.getParameter("catalogServiceSector");
		String csa=(String)request.getParameter("catalogServiceArea");
		String pc=(String)request.getParameter("productCategory");
		String pt=(String)request.getParameter("productType");
		String imageUrl=(String)request.getParameter("imageUrl");
		String rate=(String)request.getParameter("productRate");
		//fill your code here
		// Parse the rate to a double value
	    double rate1;
	    try {
	        rate1 = Double.parseDouble(rate);
	    } catch (NumberFormatException e) {
	        // Handle invalid rate value
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product rate.");
	        return;
	    }
	 // Create and populate Product object
	    Product product = new Product();
	    product.setName(name);
	    product.setColor(color);
	    product.setDimensions(dimensions);
	    product.setCity(city);
	    product.setImageUrl(imageUrl);
	    // Use business objects to get related domain objects
	    try {
	        ProductBO productBO = new ProductBO();
	        
	        // Set the product's rate
	        ProductRate productRate = new ProductRate();
	        productBO.addProduct(product);

	        // You may need to integrate the ProductRate object with your codebase
	        // and set it appropriately if necessary.

	        // Use ProductBO to add the product
	        Product addedProduct = productBO.addProduct(product);

	        if (addedProduct != null) {
	            // Respond with success message
	            response.getWriter().write("Product created successfully.");
	        } else {
	            // Respond with error message
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to create product.");
	        }
	    } catch (Exception e) {
	        // Handle exception
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing the request.");
	    }
	 //mycode is closed
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
