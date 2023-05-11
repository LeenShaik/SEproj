package system;

public class Customer {

	String id;
	String name;
	String email;
	String phone;
	String address;
    int numOfReq;
	public Customer(String id,String name,String email,int numOfReq,String phone,String address) {
		this.id=id;
		this.email=email;
		this.name=name;
		this.phone=phone;
		this.address=address;
		this.numOfReq=numOfReq;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public void setUserName(String email) {
		this.email=email;
	}
	public void setAddress(String a) {
		this.address=a;
	}
	public void setPhone(String p) {
		this.phone=p;
	}
	public void setNumOfReq(int n) {
		this.numOfReq=n;
	}
	

	public boolean hasDiscount() {
		boolean hasDiscount;
		if(numOfReq >=5)
			hasDiscount = true;
		else
			hasDiscount=false;
		
	return hasDiscount;	
	}

		
		
	
	
}
