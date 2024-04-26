package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import Utility.DBConnection;
import BO.AddressBO;
import BO.ProductBO;
import BO.RentalPackageBO;
import BO.UserBO;
import Domain.OrderDetail;
import Domain.Product;
import Domain.RentalPackage;

public class OrderDetailDAO {

	public OrderDetail create(OrderDetail order) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into order_detail(user_id, name, contact_no, ordered_date, delivery_date, delivery_time, address_id, cost_per_month) values(?,?,?,?,?,?,?,?)");
		ps.setLong(1, order.getUser().getId());
		ps.setString(2, order.getName());
		ps.setString(3, order.getContactNo());
		ps.setDate(4, new Date(order.getOrderedDate().getTime()));
		ps.setDate(5, new Date(order.getDeliveryDate().getTime()));
		ps.setString(6, order.getDeliveryTime());
		ps.setLong(7, order.getAddress().getId());
		ps.setInt(8, order.getCostPerMonth());
		
		int result = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();	
		
		if(rs.next()){
			order.setId(rs.getLong(1));
		}
		
		String queryString = "";
		if(order.getProductList().size() > 0){					
			for(Product p : order.getProductList()){
				ps = con.prepareStatement("insert into order_detail_product(order_detail_id,product_id) values(?,?)");
				ps.setLong(1, order.getId());
				ps.setLong(2, p.getId());
				ps.executeUpdate();
			}
			
		}
		queryString = "";
		if(order.getRentalPackageList().size() > 0 ){
			for(RentalPackage pkg : order.getRentalPackageList()){
				ps = con.prepareStatement("insert into order_detail_rental_package(order_detail_id,package_id) values(?,?)");
				ps.setLong(1, order.getId());
				ps.setLong(2, pkg.getId());
				ps.executeUpdate();
			}
			
		}
		
		con.close();
		return order;
	}
	
	public OrderDetail findById(Integer id) throws Exception{
		
		 OrderDetail order = null;
		ArrayList<Product> productList = (ArrayList<Product>) new ProductBO().getProductsByOrder(id);

		ArrayList<RentalPackage> packageList = (ArrayList<RentalPackage>) new RentalPackageBO().getRentalPackagesByOrder(id);
				

		Connection con = DBConnection.getConnection();
		
               //fill your code here
		PreparedStatement ps = con.prepareStatement("SELECT * FROM order_detail WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Retrieving order details
            order = new OrderDetail();
            order.setId(rs.getLong("id"));
            // Assuming there are corresponding BO classes for User and Address
            order.setUser(new UserBO().findById(rs.getInt("user_id")));
            order.setName(rs.getString("name"));
            order.setContactNo(rs.getString("contact_no"));
            order.setOrderedDate(rs.getDate("ordered_date"));
            order.setDeliveryDate(rs.getDate("delivery_date"));
            order.setDeliveryTime(rs.getString("delivery_time"));
            // Assuming there's a BO class for Address
            order.setAddress(new AddressBO().findById(rs.getInt("address_id")));
            order.setCostPerMonth(rs.getInt("cost_per_month"));

            // Fetching associated products and rental packages
            productList = (ArrayList<Product>) new ProductBO().getProductsByOrder(order.getId());
            packageList = (ArrayList<RentalPackage>) new RentalPackageBO().getRentalPackagesByOrder(order.getId());
        }

        // Setting products and rental packages to the order
        if (order != null) {
            order.setProductList(productList);
            order.setRentalPackageList(packageList);
        }

		con.close();
		return null;
	}
}
