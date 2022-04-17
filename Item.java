
package oopBD_SilviqDancheva;

public class Item extends BaseClass {
	
	String name;
	String description;
	User seller;
	User buyer;
	float price;
	
	Item(int id, String name, String description, User seller, User buyer, float price) {
		super(id);
		this.name=name;
		this.description=description;
		this.seller=seller;
		this.buyer=buyer;
		this.price=price;
	}
	Item(){
		
	}
	
	String getName() {
		return name;
	}
	String getDescription() {
		return description;
	}
	User getSeller() {
		return seller;
	}
	User getBuyer() {
		return buyer;
	}
	float getPrice() {
		return price;
	}

}
