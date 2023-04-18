package system;

public class Order {
	String oId,cId,pId,wId;
	Status status=Status.WAITING;
	int deliveryPrice,productPrice;
	
	public Order(String oId,String cId,String pId,String wId) {
		this.oId=oId;
		this.cId=cId;
		this.pId=pId;
		this.wId=wId;
	}
	public void setStatus(Status s) {
		status=s;
	}
	public Status getStatus() {
		return status;
	}
	public int diliveryPriceCalc(Customer c ) {
		cId=c.id;
		String s=c.address;
		deliveryPrice=12;
		if(s.toUpperCase().trim()=="DERALHATAB")
			deliveryPrice=20;
		else if(s.toUpperCase().trim()=="TELSTREET")
			deliveryPrice=15;
		else if(s.toUpperCase().trim()=="MREGSTREET")
			deliveryPrice=15;
		else if(s.toUpperCase().trim()=="STREER15")
			deliveryPrice=14;
		else if(s.toUpperCase().trim()=="ASERA")
			deliveryPrice=18;
		else if(s.toUpperCase().trim()=="DERSHARAF")
			deliveryPrice=18;
		else deliveryPrice=12;
		return deliveryPrice;
	}
	public int productPriceCalc(Customer c,Product p) {
		
		if(c.hasDiscount() == true) {
			productPrice=(p.price) - ((int)( p.price*0.15));
			
		}
		else {
			productPrice=p.price;
		}
		return productPrice ;
	}
	public int total() {
		int total=deliveryPrice+productPrice;
		return total;
		
	}
}
