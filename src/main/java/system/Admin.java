package system;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Admin {
	boolean logState,l;
    MySystem s1;
	//ArrayList<Admin>Admins=s1.getList();
	String username,pass,email,phone;
	public Admin() {
		username ="leen.aljaber123@gmail.com";
		pass="12345l";
		logState=false;
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
	public boolean login(String username,String pass) {
		if(logState) {
			System.out.println("you are already logged in");
			l=false;
			}
		else {
			for(int i=0;i<s1.Admins.size();i++) {
				if(s1.Admins.get(i).username ==username && s1.Admins.get(i).pass==pass) {
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
	public String register(Customer c, MySystem ms) {
		if(logState==false) {
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<ms.Customers.size();i++) {
				if(c.id.equals(ms.Customers.get(i).id)) {
					JOptionPane.showInternalMessageDialog(null, "customer is alreay registered", "Error", JOptionPane.ERROR_MESSAGE);
					return "customer is alreay registered";
				}
			}
			ms.Customers.add(c);
			JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
			return "customer registered succefully";
		}
	}
	public String update(String whatUpdate, String ID,String newValue) {
		String s=whatUpdate;
		if(logState==false) {
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<s1.Customers.size();i++) {
				if(ID.equals(s1.Customers.get(i).id)) {
					if(s == "address") 
						s1.Customers.get(i).setAddress(newValue);
					else if(s=="name")
						s1.Customers.get(i).setName(newValue);
					else if(s=="pass")
						s1.Customers.get(i).setPass(newValue);
					else if (s=="username")
						s1.Customers.get(i).setUserName(newValue);
					else if(s=="phone")
						s1.Customers.get(i).setPhone(newValue);
					else if(s=="numOfReq")
						s1.Customers.get(i).setNumOfReq(Integer.parseInt(newValue));
					JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
					return "customer updated successfully";
				}
			}
			JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return "customer is not registered";
		}
		
	}
	

}
