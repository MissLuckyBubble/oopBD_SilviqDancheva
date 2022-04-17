package oopBD_SilviqDancheva;

public class User extends BaseClass {
	String username;
	Adress adress;
	String gender;
	
	User(int id, String username, Adress adress, String gender) {
		super(id);
		this.username=username;
		this.adress=adress;
		this.gender=gender;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	String getUsername() {
		return username;
	}
	Adress getAdress() {
		return adress;
	}
	String getGender() {
		return gender;
	}

}
