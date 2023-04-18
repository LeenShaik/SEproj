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
	public boolean getLoginState() {
		return logState;
		}
	public boolean login(String username,String pass) {
		if(logState) {
			System.out.println("you are already logged in");
			return false;
			}
		else {
			if(username == "leen.aljaber123@gmail.com" && pass=="12345l") {
				System.out.println("successfull log in");
				logState=true;
				return true;}
			else {
				System.out.println("wrong username or password !! ");
				return false;
					}
			}
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
	public String update(MySystem s1,String w, String iD,String n) {
		String whatUpdate =w;
		String newValue =n;
		String id=iD;
		if(logState==false) {
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<s1.Customers.size();i++) {
				if(id.equals(s1.Customers.get(i).id)) {
					if(whatUpdate == "address") 
						s1.Customers.get(i).setAddress(newValue);
					else if(whatUpdate=="name")
						s1.Customers.get(i).setName(newValue);
					else if (whatUpdate=="username")
						s1.Customers.get(i).setUserName(newValue);
					else if(whatUpdate=="phone")
						s1.Customers.get(i).setPhone(newValue);
					else if(whatUpdate=="numOfReq")
						s1.Customers.get(i).setNumOfReq(Integer.parseInt(newValue));
					JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
					return "customer updated successfully";
				}
			}
			JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return "customer is not registered";
		}
		
	}
	public String addProduct(Product p, MySystem ms) {
			
				for(int i=0;i<ms.Products.size();i++) {
					if(p.id==ms.Products.get(i).id) {
						JOptionPane.showInternalMessageDialog(null, "product is already valid", "Error", JOptionPane.ERROR_MESSAGE);
						return "product is already valid";
					}
				}
				ms.Products.add(p);
				JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
				return "product added succefully";
			
		
	}
	public String deleteCustomer(MySystem ms,String iD) {
		int index=-1;
			for(int i=0;i<ms.Customers.size();i++) {
				if(!(iD.equals(ms.Customers.get(i).id))) {
					JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
					return "customer is not registered";
				}
				else {
					index=i;
				    break;}
			}
			
			ms.Customers.remove(index);
			JOptionPane.showInternalMessageDialog(null, "customer deleted successfully", "success", JOptionPane.INFORMATION_MESSAGE);
			return "customer deleted successfully";
		
	}
	public String deleteProduct( MySystem ms,String iD) {
		int index=-1;
		if(logState==false) {
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<ms.Products.size();i++) {
				if(!(iD==ms.Products.get(i).id)) {
					JOptionPane.showInternalMessageDialog(null, "product is not valid", "Error", JOptionPane.ERROR_MESSAGE);
					return "product is not valid";
				}
				else {
					 index=i;
					 break;}
			}
			ms.Products.remove(index);
			JOptionPane.showInternalMessageDialog(null, "product deleted successfully", "success", JOptionPane.INFORMATION_MESSAGE);
			return "product deleted successfully";
		}
	}
	public String updateProduct(MySystem s1,String w, String iD, String n) {
		String id=iD;
		String whatUpdate=w;
		String newValue=n;
		if(logState==false) {
			JOptionPane.showInternalMessageDialog(null, "Admin login is required", "Error", JOptionPane.ERROR_MESSAGE);
			return "Admin login is required";
		}
		else {
			for(int i=0;i<s1.Products.size();i++) {
				if(id.equals(s1.Products.get(i).id)) {
					if(whatUpdate == "name") 
						s1.Products.get(i).setName(newValue);
					else if(whatUpdate=="price")
						s1.Products.get(i).setPrice(Integer.valueOf(newValue));
					JOptionPane.showInternalMessageDialog(null, "product updated successfully", "success", JOptionPane.INFORMATION_MESSAGE);
					return "product updated successfully";
				}
			}
			JOptionPane.showInternalMessageDialog(null, "product is not valid", "Error", JOptionPane.ERROR_MESSAGE);
			return "product is not valid";
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
		public void sendEmail(String email) {
		      String from = "leen.aljaber123@gmail.com";
			  String to = email;
		      String host = "localhost";
		      Properties properties = System.getProperties();
		      properties.setProperty("mail.smtp.host", host);
		      Session session = Session.getDefaultInstance(properties);

		      try {

		         MimeMessage message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(from));
		         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		         message.setSubject("order complete!");

		         message.setText("Your order is completed , thank you for dealing with us :)");
		         Transport.send(message);
		         System.out.println("Sent message successfully....");
		      } catch (MessagingException mex) {
		         mex.printStackTrace();
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
		
		
	
	


