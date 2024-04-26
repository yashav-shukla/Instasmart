package BO;

import java.sql.SQLException;

import DAO.OrderDetailDAO;
import Domain.OrderDetail;

public class OrderDetailBO {
	public OrderDetail create(OrderDetail order) throws ClassNotFoundException, SQLException{
		return new OrderDetailDAO().create(order);
	}
public OrderDetail findById(Integer id) throws Exception {
	        return new OrderDetailDAO().findById(id);
	    }
}
