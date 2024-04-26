package Domain;

public class Address {
	private Integer id;
	private Integer user; //convert the User user -Integer
	private String street;
	private String city;
	private String state;
	private String country;
	private Integer pincode;
	
	public Address(String street, Integer user, Integer id, String city, String state, Integer pincode, String country) {
		super();
		this.id = id;
		this.user = user;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public Address() {
		super();
		this.id = id;
		this.user = user;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	public String toString(){
		return String.format("%-15s %-15s %-15s %-15s %-15s %s",this.getId(), this.getStreet(),this.getCity(),this.getState(),this.getCountry(),this.getPincode());
	}
}
