

import java.io.IOException;
import java.util.ArrayList;

import BO.DiscountBO;
import BO.ProductBO;
import BO.ProductRateBO;
import Domain.Discount;
import Domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String s=request.getParameter("productId");
		try{
		Product p=new ProductBO().findById(Integer.parseInt(s));
		session.setAttribute("product", p);
		Integer costPerMonth = 0;
		if( p != null){
			
			int cost =  new ProductRateBO().obtainProductRateByProduct(p).getRate();
			if(cost > 0){
				costPerMonth += cost;
			}
		}
		System.out.println(costPerMonth);
		request.setAttribute("product", p);
		
		request.setAttribute("costPerMonth", costPerMonth);
		session.setAttribute("costPerMonth", costPerMonth);
		DiscountBO discountBO = new DiscountBO();
		ArrayList<Discount> discountList = discountBO.listAllDiscount();
		System.out.println(discountList);
		request.setAttribute("tensureList", discountList);
		session.setAttribute("tensureList", discountList);
		//fill your code here
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
