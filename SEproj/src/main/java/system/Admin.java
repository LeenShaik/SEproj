package system;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class Admin {
	boolean logState;
	String username,pass,email,phone;
	public Admin() {
		username ="leen.aljaber123@gmail.com";
		pass="12345l";
		//logState=false;
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
			System.out.println("you are already logged in");
			return false;
			}
		else {
			if(username.equals("leen.aljaber123@gmail.com") && pass.equals("12345l")) {
				System.out.println("welcom leen, choose what you want to do");
				logState=true;
				return true;}
			else {
				System.out.println("wrong username or password !! ");
				return false;
					}
			}
		}

	
	public String search(String id, MySystem s1) {
		
		if(logState==false) {
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<s1.Customers.size();i++) {
				if(id.equals(s1.Customers.get(i).id)) {
				return "coustomer information => id:"+s1.Customers.get(i).id + ", name:"+s1.Customers.get(i).name+", email:"+s1.Customers.get(i).email+" , number of requests:"+s1.Customers.get(i).numOfReq+" , phone number:"+s1.Customers.get(i).phone+" , address:"+s1.Customers.get(i).address;
				}
			}
			JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return "customer is not registered";
		}
		}
		public String searchProduct(String id, MySystem s1) {
			String iD=id;
			if(logState==false) {
				JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
				return "Admin login is required";
			}
			else {
				for(int i=0;i<s1.Products.size();i++) {
					if(iD.equals(s1.Products.get(i).id)) {
						return "product information => id:"+s1.Products.get(i).id+" , name:"+s1.Products.get(i).name+" , price:"+s1.Products.get(i).price;
					}
					}
				}
				JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
				return "product is not valid";
			}
		public void logOut() {
			
			if(logState ==false ) {
			
			}
			else {
				logState=false;
				
			}
			
		}
		
		public String distribute(MySystem ms ,Worker w, Order o) {
			int index=-1;
			for(int i=0;i<ms.Workers.size();i++) {
				if(ms.Workers.get(i).getIsFree()) {
					index=i;
					o.wId=ms.Workers.get(i).id;
					w.setIsFree(false);
					o.setStatus(Status.INTREATMENT);
					break;
				}
			}
			if(index==-1) {
				return "all worker is not available";
			}
			return "worker"+ms.Workers.get(index).id+"received the order";
			
		}
		
		}
		
		
	
	


