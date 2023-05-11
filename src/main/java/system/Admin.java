package system;

public class Admin {
	boolean logState;
	String username;
	String pass;
	String email;
	String phone;
	public Admin() {
		username ="leen.aljaber123@gmail.com";
		pass="12345l";
	}
	public Admin (String username ,String pass,String email,String phone) {
		this.username=username;
		this.pass=pass;
		this.email=email;
		this.phone=phone;
	}
	public void setLoginState(boolean b) {
		logState=b;	
	}
	public boolean getLoginState() {
		return logState;
		}
	public boolean login(String username,String pass) {
		if(logState) {
			
			return false;
			}
		else {
			if(username.equals("leen.aljaber123@gmail.com") && pass.equals("12345l")) {
				logState=true;
				return true;}
			else {
				return false;
					}
			}
		}

	
	public String search(String id, MySystem s1) {
		
		if(!logState) {
			return "Admin login is required";
		}
		else {
			for(int i=0;i<s1.customers.size();i++) {
				if(id.equals(s1.customers.get(i).id)) {
				return "coustomer information => id:"+s1.customers.get(i).id + ", name:"+s1.customers.get(i).name+", email:"+s1.customers.get(i).email+" , number of requests:"+s1.customers.get(i).numOfReq+" , phone number:"+s1.customers.get(i).phone+" , address:"+s1.customers.get(i).address;
				}
			}
			return "customer is not registered";
		}
		}
		public String searchProduct(String id, MySystem s1) {
			String iD=id;
			if(!logState) {
				return "Admin login is required";
			}
			else {
				for(int i=0;i<s1.products.size();i++) {
					if(iD.equals(s1.products.get(i).id)) {
						return "product information => id:"+s1.products.get(i).id+" , name:"+s1.products.get(i).name+" , price:"+s1.products.get(i).price;
					}
					}
				}
				return "product is not valid";
			}
		public void logOut() {
			
			if(logState) {
				logState=false;
			}
			
			
		}
		
		public String distribute(MySystem ms ,Worker w, Order o) {
			int index=-1;
			for(int i=0;i<ms.workers.size();i++) {
				if(ms.workers.get(i).getIsFree()) {
					index=i;
					o.wId=ms.workers.get(i).id;
					w.setIsFree(false);
					o.setStatus(Status.INTREATMENT);
					break;
				}
			}
			if(index==-1) {
				return "all worker is not available";
			}
			return "worker"+ms.workers.get(index).id+"received the order";
			
		}
		
		}
		
		
	
	


