package system;

import java.util.ArrayList;

public class Customer {
	boolean logState,l;
    MySystem s1;
	int invoiceC;
	boolean hasD=false;
	String id,name ,pass,username,phone,address;
	static int numOfReq;
	public Customer(String id,String name,String pass,String email,int numOfReq,String phone,String address) {
		this.id=id;
		this.username=email;
		this.pass=pass;
		this.name=name;
		this.phone=phone;
		this.address=address;
		this.numOfReq=numOfReq;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	public void setUserName(String email) {
		this.username=email;
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
	public void setLoginState(boolean b) {
		logState=b;	
	}
	public boolean login(String username,String pass) {
		if(logState) {
			System.out.println("you are already logged in");
			l=false;
			}
		else {
			for(int i=0;i<s1.Customers.size();i++) {
				if(s1.Customers.get(i).username ==username && s1.Customers.get(i).pass==pass) {
					System.out.println("successfull log in");
					logState=true;
					l=true;
					break;
					}
				
			else {
					System.out.println("wrong username or password !! ");
					l=false;
					}
				}
			}
		return l;
		}
	public boolean getLoginState() {
		return logState;
		}
	public boolean isregistered(Customer c) {
		boolean reg=false;
		for(int i=0;i<s1.Customers.size();i++) {
			if(s1.Customers.get(i).id == c.id) {
				reg=true;
				break;
				}
			}
		return reg;
	}
	public boolean hasDiscount() {
		if(Customer.numOfReq>=10) {
			hasD=true;	
		}
	return hasD;	
	}
	

}
