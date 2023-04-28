package system;

public class Order {
	String oId,cId,pId,wId;
	Status status=Status.WAITING;
	int numOfOrder,deliveryPrice,productPrice;
	
	
	public Order(String oId,String cId,String pId,String wId,int numOfOrder,int deliveryPrice,int productPrice,Status s ) {
		this.oId=oId;
		this.cId=cId;
		this.pId=pId;
		this.wId=wId;
		this.numOfOrder=numOfOrder;
		this.deliveryPrice=deliveryPrice;
		this.productPrice=productPrice;
		
		status=s;
	}
	public void setStatus(Status s) {
		status=s;
	}
	public Status getStatus() {
		return status;
	}
	
}
