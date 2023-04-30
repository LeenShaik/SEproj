package system;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class MySystem {
	public ArrayList<Customer> Customers =new ArrayList<Customer>();
	public ArrayList<Product> Products=new ArrayList<Product>();
	public ArrayList<Worker> Workers=new ArrayList<Worker>();
	public ArrayList<Order> Orders=new ArrayList<Order>();	
	
	public boolean Report() {
		int i,c=0,d=0,w=0;
		System.out.println("These customers are registered in the system");
		System.out.printf("%-20s|%-20s|%-25s|%-20s|%-10s|%-20s|%n","Id","Name","email","Number of request","Phone","address");
		for ( i=0;i<Customers.size();i++) {
            
            System.out.printf("%-20s|%-20s|%-25s|%-20d|%-10s|%-20s|%n",Customers.get(i).id,Customers.get(i).name,Customers.get(i).email,Customers.get(i).numOfReq,Customers.get(i).phone,Customers.get(i).address);
            c=1;
		}
		i=0;
		System.out.println("_____________________________________________________________________________________________________________"+"\n");
		System.out.println("These products are valid in the system");
		System.out.printf("%-10s|%-42s|%-10s|%n","Id","Name","price");
		for (i=0;i<Products.size();i++) {
            
            System.out.printf("%-10s|%-42s|%-10d|%n",Products.get(i).id,Products.get(i).name,Products.get(i).price);	
			d=1;
		}
		i=0;
		System.out.println("_____________________________________________________________________________________________________________"+"\n");
		System.out.println("These workers works in the system");
		System.out.printf("%-10s|%-20s|%-11s|%-15s|%n","Id","Name","Phone","address");
		for(i=0;i<Workers.size();i++) {
             
             System.out.printf("%-10s|%-20s|%-11s|%-15s|%n",Workers.get(i).id,Workers.get(i).name,Workers.get(i).phone,Workers.get(i).address);
			 w=1;
		}
		
		if(c==1&&d==1&&w==1) {
			return true;
		}
		return false;
	}
	
	public int totalCash() {
		int cash=0;
		for(int i=0;i<Orders.size();i++) {
			cash+=Orders.get(i).productPrice;
		}
		return cash;
	}
	public int totaldelivery() {
		int delivery=0;
		for(int i=0;i<Orders.size();i++) {
			if(Orders.get(i).deliveryPrice != 0)
				delivery+=1;
		}
		return delivery;
	}
	public int totalPaid() {
		int size=Orders.size()+1;
		return 5*size;
	}
	public String register(Customer c) {
			for(int i=0;i<Customers.size();i++) {
				if(c.id.equals(Customers.get(i).id)) {
					return "customer is alreay registered";
				}
			}
			Customers.add(c);
			return "customer registered succefully";
		
	}
	public String update(String w, String iD,String n) {
		String whatUpdate =w;
		String newValue =n;
		String id=iD;
			for(int i=0;i<Customers.size();i++) {
				if(id.equals(Customers.get(i).id)) {
					if(whatUpdate.equals("address")) 
						Customers.get(i).setAddress(newValue);
					else if(whatUpdate.equals("name"))
						Customers.get(i).setName(newValue);
					else if (whatUpdate.equals("username"))
						Customers.get(i).setUserName(newValue);
					else if(whatUpdate.equals("phone"))
						Customers.get(i).setPhone(newValue);
					else if(whatUpdate.equals("numOfReq"))
						Customers.get(i).setNumOfReq(Integer.parseInt(newValue));
					return "customer updated successfully";
				}
			}
			return "customer is not registered";
		
		
	}
	public String addProduct(Product p) {
			
				for(int i=0;i<Products.size();i++) {
					if(p.id.equals(Products.get(i).id)) {
						return "product is already valid";
					}
				}
				
				Products.add(p);
				return "product added succefully";
			
		
	}
	public String deleteCustomer(String iD) {
		int index=-1;
			for(int i=0;i<Customers.size();i++) {
				if(iD.equals(Customers.get(i).id)) {
					index=1;
					
				}
				
			}
			
			if(index==-1) {
				return "customer is not registered";
			}
			else {
			Customers.remove(index);
			return "customer deleted successfully";}
		
	}
	public String deleteProduct(String iD) {
		int index=-1;
		
			for(int i=0;i<Products.size();i++) {
				if(iD.equals(Products.get(i).id)) {
					index=i;
				}
				
			}
			if(index==-1) {
				return "product is not valid";
			}
			else {
			Products.remove(index);
			return "product deleted successfully";}
		
	}
	public String updateProduct(String w, String iD, String n) {
		String id=iD;
		String whatUpdate=w;
		String newValue=n;
		int flag=0;
		
			for(int i=0;i<Products.size();i++) {
				if(id.equals(Products.get(i).id)) {
					if(whatUpdate .equals("name")) {
						Products.get(i).setName(newValue);
						flag=1;
					}
					else if(whatUpdate.equals("price")) {
						Products.get(i).setPrice(Integer.valueOf(newValue));
						flag=1;
					}
					
				}
			}
			if(flag==1)
				return "product updated successfully";
			else 
				return "product is not valid";
		
	}
	public void list() {
	    System.out.print("1- Add,Delete,Search,Update Customer "+"\n");
	    System.out.print("2- Add,Delete,Search,Update Product "+"\n");
	    System.out.print("3- add new order "+"\n");
	    System.out.print("4- Report for the system "+"\n");
	    System.out.print("5- Print total cash,paid,delivered items "+"\n");
	    System.out.print("6- Logout "+"\n");

}
	public boolean CustomerValid(String id) {
		int flag=0;
		for(int i=0;i<Customers.size();i++) {
			if(Customers.get(i).id.equals(id))
				flag =1;
		}
		if(flag==1)
			return true;
		else 
			return false;
	}
	public boolean ProductValid(String id) {
		int flag=0;
		for(int i=0;i<Products.size();i++) {
			if(Products.get(i).id.equals(id))
				flag =1;
		}
		if(flag==1)
			return true;
		else 
			return false;
	}
	public void productList() {
		System.out.println("0-if he want to clean CARPET minimum than 9");
		System.out.println("1-if he want to clean CARPET greater than 9 and smaller than 16");
		System.out.println("2-if he want to clean CARPET greater than 16");
		System.out.println("3-if he want to clean SINGLE COVER");
		System.out.println("4-if he want to clean COUPLE COVER");
		System.out.println("5-if he want to clean CURTAIN");

	}
	public String distribute( Order o) {
		int index=-1;
		for(int i=0;i<Workers.size();i++) {
			if(Workers.get(i).getIsFree()) {
				index=i;
				o.wId=Workers.get(i).id;
				Workers.get(i).setIsFree(false);
				o.setStatus(Status.INTREATMENT);
				break;
			}
		}
		if(index==-1) {
			return "all worker is not available";
		}
		else 
			return "worker"+Workers.get(index).id+"received the order";
		
	}
	public String sendEmail(String email) {
		  String s="Sent message successfully...";
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
	         
	        
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		 return s;
	   }
	public int diliveryPriceCalc(Customer c ) {
		String s=c.address;
		int deliveryPrice=12;
		if(s.toUpperCase().trim().equals("DERALHATAB"))
			deliveryPrice=20;
		else if(s.toUpperCase().trim().equals("TELSTREET"))
			deliveryPrice=15;
		else if(s.toUpperCase().trim().equals("MREGSTREET"))
			deliveryPrice=15;
		else if(s.toUpperCase().trim().equals("STREER15"))
			deliveryPrice=14;
		else if(s.toUpperCase().trim().equals("ASERA"))
			deliveryPrice=18;
		else if(s.toUpperCase().trim().equals("DERSHARAF"))
			deliveryPrice=18;
		else deliveryPrice=12;
		return deliveryPrice;
	}
	public int productPriceCalc(Customer c,Product p,int numOfOrder) {
		int productPrice;
		if(c.hasDiscount() == true) {
			productPrice=(p.price)*numOfOrder - ((int)( p.price*0.15));
			
		}
		else {
			productPrice=p.price;
		}
		return productPrice ;
	}
	/*public int total() {
		
		int total=deliveryPrice+productPrice;
		return total;
		
	}*/
	
}
