package system;

public class InvoiceCalc {
	int numOfProduct = 1;
	int Invoice;
	Customer c;
	Product p;
	int totalInvoice;
	int delivery;
	
	
	public int total(productName n,int productSpace,int numOfProduct) {
		
		if(c.hasDiscount() == true) {
			Invoice=(p.priceForProduct(n,productSpace) *numOfProduct) - ((int)( p.priceForProduct(n,productSpace) *numOfProduct *0.15));
			totalInvoice=Invoice + totalDelivery();
		}
		else {
		Invoice=p.priceForProduct(n,productSpace) *numOfProduct;
		totalInvoice=Invoice+ totalDelivery();
		}
		return totalInvoice;
	}
	public int totalDelivery() {
		String s;
		s=c.address;
		int deliveryPrice=12;
		if(s.toUpperCase().trim()=="DERALHATAB")
			deliveryPrice=30;
		else if(s.toUpperCase().trim()=="TELSTREET")
			deliveryPrice=15;
		else if(s.toUpperCase().trim()=="MREGSTREET")
			deliveryPrice=15;
		else if(s.toUpperCase().trim()=="STREER15")
			deliveryPrice=14;
		else if(s.toUpperCase().trim()=="ASERA")
			deliveryPrice=25;
		else if(s.toUpperCase().trim()=="DERSHARAF")
			deliveryPrice=18;
		else deliveryPrice=12;
		return deliveryPrice;
	}
	

	
	
}
