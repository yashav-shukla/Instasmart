package Domain;

import java.util.Date;

public class ProductRate {
	Integer id;
	Integer product_id; // change by - Product product
	Integer rate;
	Date startDate;
	Date endDate;
	
	public ProductRate(Integer id, Integer product_id, Integer rate, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.rate = rate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ProductRate() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
