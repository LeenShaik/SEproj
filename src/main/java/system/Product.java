package system;

public class Product {
	productName pName;
	int productSpace ;
	//int numOfProduct;
	public void Product() {
		productSpace=4;
	//	numOfProduct=1;
	}
	
	public int priceForProduct(productName name ,int productSpace) {
		this.pName=name;this.productSpace=productSpace;
		int price=0;
		switch(pName) {
		case CARPET:
			if(productSpace<=9)
				price=15;
			else if(productSpace>9 && productSpace<=16)
				price=20;
			else if(productSpace>16)
				price=30;
			break;
		case SINGLECOVER:
			price=13;
			break;
		case COUPLECOVER:
			price=20;
			break;
		case CURTAIN:
			price=8;
			break;
		}
		return price;
	}
	
	
}
