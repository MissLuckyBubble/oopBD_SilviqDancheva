package oopBD_SilviqDancheva;


public class Adress extends BaseClass {

	String country;
	String city;
	String street;

	
	Adress(int id, String country, String city, String street) {
		super(id);
		this.country=country;
		this.city=city;
		this.street=street;
	}

	public Adress() {
		
	}

	String getCoutry() {
		return country;
	}
	String getCity() {
		return city;
	}
	String getStreet() {
		return street;
	}


	
}
