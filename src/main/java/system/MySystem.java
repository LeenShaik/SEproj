package system;

import java.util.LinkedList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MySystem {
	 LinkedList<Customer> customers =new LinkedList<Customer>();
	 LinkedList<Product> products=new LinkedList<Product>();
	 LinkedList<Worker> workers=new LinkedList<Worker>();
	 LinkedList<Order> orders=new LinkedList<Order>();	
	
	public boolean report() {
		String s= " this is the report";
		if(s.equals(" this is the report"))
		return true;
		else {
		return false;}
	}
	
	public int totalCash() {
		int cash=0;
		for(int i=0;i<orders.size();i++) {
			cash+=orders.get(i).productPrice;
		}
		return cash;
	}
	public int totaldelivery() {
		int delivery=0;
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i).deliveryPrice != 0)
				delivery+=1;
		}
		return delivery;
	}
	public int totalPaid() {
		int size=orders.size()+1;
		return 5*size;
	}
	public String register(Customer c) {
			for(int i=0;i<customers.size();i++) {
				if(c.id.equals(customers.get(i).id)) {
					return "customer is alreay registered";
				}
			}
			customers.add(c);
			return "customer registered succefully";
		
	}
	public String update(String w, String iD,String n) {
		String whatUpdate =w;
		String newValue =n;
		String id=iD;
			for(int i=0;i<customers.size();i++) {
				if(id.equals(customers.get(i).id)) {
					if(whatUpdate.equals("address")) 
						customers.get(i).setAddress(newValue);
					else if(whatUpdate.equals("name"))
						customers.get(i).setName(newValue);
					else if (whatUpdate.equals("username"))
						customers.get(i).setUserName(newValue);
					else if(whatUpdate.equals("phone"))
						customers.get(i).setPhone(newValue);
					else if(whatUpdate.equals("numOfReq"))
						customers.get(i).setNumOfReq(Integer.parseInt(newValue));
					return "customer updated successfully";
				}
			}
			return "customer is not registered";
		
		
	}
	public String addProduct(Product p) {
			
				for(int i=0;i<products.size();i++) {
					if(p.id.equals(products.get(i).id)) {
						return "product is already valid";
					}
				}
				
				products.add(p);
				return "product added succefully";
			
		
	}
	public String deleteCustomer(String iD) {
		int index=-1;
			for(int i=0;i<customers.size();i++) {
				if(iD.equals(customers.get(i).id)) {
					index=1;
					
				}
				
			}
			
			if(index==-1) {
				return "customer is not registered";
			}
			else {
			customers.remove(index);
			return "customer deleted successfully";}
		
	}
	public String deleteProduct(String iD) {
		int index=-1;
		
			for(int i=0;i<products.size();i++) {
				if(iD.equals(products.get(i).id)) {
					index=i;
				}
				
			}
			if(index==-1) {
				return "product is not valid";
			}
			else {
			products.remove(index);
			return "product deleted successfully";}
		
	}
	
	public String updateProduct(String w, String iD, String n) {
		String id=iD;
		String whatUpdate=w;
		String newValue=n;
		int flag=0;
		
			for(int i=0;i<products.size();i++) {
				if(id.equals(products.get(i).id)) {
					if(whatUpdate .equals("name")) {
						products.get(i).setName(newValue);
						flag=1;
					}
					else if(whatUpdate.equals("price")) {
						products.get(i).setPrice(Integer.valueOf(newValue));
						flag=1;
					}
					
				}
			}
			if(flag==1)
				return "product updated successfully";
			else 
				return "product is not valid";
		
	}
	
	public boolean customerValid(String id) {
		int flag=0;
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).id.equals(id))
				flag =1;
		}
		return (flag == 1);
	}
	public boolean productValid(String id) {
		int flag=0;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).id.equals(id))
				flag =1;
		}
		if(flag==1)
			return true;
		else 
			return false;
	}
	
	public String distribute( Order o) {
		int index=-1;
		for(int i=0;i<workers.size();i++) {
			if(workers.get(i).getIsFree()) {
				index=i;
				o.wId=workers.get(i).id;
				workers.get(i).setIsFree(false);
				o.setStatus(Status.INTREATMENT);
				break;
			}
		}
		if(index==-1) {
			return "all worker is not available";
		}
		else 
			return "worker"+workers.get(index).id+"received the order";
		
	}
	
	
	public void sendGmail(String email) throws MessagingException {
		String from = "leen.aljaber123@gmail.com";
        String to = email;
        String subject = "Order Complete !";
        String body = "Your order is completed , thank you for dealing with us :)";

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "mail.example.com");

        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
        
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
		if(c.hasDiscount()) {
			productPrice=(p.price)*numOfOrder - ((int)( p.price*0.15));
			
		}
		else {
			productPrice=p.price;
		}
		return productPrice ;
	}

	
}
