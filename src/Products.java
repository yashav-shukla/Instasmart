

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.ProductDAO;
import Domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fill your code here
		 List<Product> productList = null;
		    try {
		        ProductDAO productDAO = new ProductDAO();
		        productList = productDAO.obtainAllProductsForManager(); // Adjust parameters as needed
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace(); // Handle the exception appropriately
		    }
		 // Set the list of products as an attribute in the request
		    request.setAttribute("productList", productList);

		    // Forward the request to the JSP page
		    request.getRequestDispatcher("listProducts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
