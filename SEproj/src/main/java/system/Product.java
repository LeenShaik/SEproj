package system;

public class Product {
	String id,name;
	int price;
	
	public Product(String id, String name, int price2) {
		this.id=id;
		this.name=name;
		this.price=price2;// TODO Auto-generated constructor stub
	}
	
	public void setName(String newValue) {
		name=newValue;
		
	}
	public void setPrice(Integer valueOf) {
		price=valueOf;
	}

	public void setId(String newValue) {
		id=newValue;
		
	}
	
	public String getName() {
		return name;
		
	}
	public int getPrice() {
		return price;
		
	}
	public String getId() {
		return id;
		
	}
	
	
	
	
	
	
	
/*	public int priceForProduct(String name,String d ) {
		this.pName=name;
		int price=15;
		if(pName.toUpperCase().trim()=="CARPET") {
			if(d=="minimum than 9")
				price=15;
			else if(productSpace>9 && productSpace<=16)
				price=20;
			else if(productSpace>16)
				price=30;
		}
		else if(pName.toUpperCase().trim()=="SINGLECOVER") {
			price=13;	
		}
		else if(pName.toUpperCase().trim()=="COUPLECOVER") {
			price=20;	
		}
		else if(pName.toUpperCase().trim()=="CURTAIN") {
			price=8;	
		}
		return price;
	}*/
	
	
}
