
import java.io.IOException;

import BO.UserBO;
import Domain.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@jakarta.servlet.annotation.WebFilter("/Validation")
public class AuthenticationFilter implements Filter {

    
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// fill your code here

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBO userBO = new UserBO();
		try {
			// Authenticate the user using UserBO
			User user = userBO.validateLogin(username, password);

			if (user != null) {
				// Set the user as a request attribute for downstream processing
				httpRequest.getSession().setAttribute("user", user);

				// Proceed with the next filter or servlet
				String role = user.getRole().getName(); // Assuming Role has a getName() method
				httpResponse.sendRedirect(role + "listProduct.jsp");
			} else {
				// Authentication failed; redirect back to the login page
				httpResponse.sendRedirect("index.jsp");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Validation.java");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
