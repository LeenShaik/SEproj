package system;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class MySystem {
	public ArrayList<Customer> Customers =new ArrayList<Customer>();
	public ArrayList<Product> Products=new ArrayList<Product>();
	public ArrayList<Worker> Workers=new ArrayList<Worker>();
	public ArrayList<Order> Orders=new ArrayList<Order>();	
	
	public boolean Report() {
		int i,c=0,d=0,w=0;
		for ( i=0;i<Customers.size();i++) {
			System.out.println("These customers are registered in the system");
            System.out.printf("%-20s|%-20s|%-25s|%-20s|%-10s|%-20s|%n","Id","Name","email","Number of request","Phone","address");
            System.out.printf("%-20s|%-20s|%-25s|%-20d|%-10s|%-20s|%n",Customers.get(i).id,Customers.get(i).name,Customers.get(i).email,Customers.get(i).numOfReq,Customers.get(i).phone,Customers.get(i).address);
            c=1;
		}
		i=0;
		System.out.println("__________________________________________________________________________________________________");
		for (i=0;i<Products.size();i++) {
       		System.out.println("These products are valid in the system");
            System.out.printf("%-10s|%-42s|%-10s|%n","Id","Name","price");
            System.out.printf("%-10s|%-42s|%-10d|%n",Products.get(i).id,Products.get(i).name,Products.get(i).price);	
			d=1;
		}
		i=0;
		for(i=0;i<Workers.size();i++) {
			 System.out.println("These workers works in the system");
             System.out.printf("%-10s|%-20s|%-11s|%-15s|%n","Id","Name","Phone","address");
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
					JOptionPane.showInternalMessageDialog(null, "customer is alreay registered", "Error", JOptionPane.ERROR_MESSAGE);
					return "customer is alreay registered";
				}
			}
			Customers.add(c);
			JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
			return "customer registered succefully";
		
	}
	public String update(String w, String iD,String n) {
		String whatUpdate =w;
		String newValue =n;
		String id=iD;
			for(int i=0;i<Customers.size();i++) {
				if(id.equals(Customers.get(i).id)) {
					if(whatUpdate == "address") 
						Customers.get(i).setAddress(newValue);
					else if(whatUpdate=="name")
						Customers.get(i).setName(newValue);
					else if (whatUpdate=="username")
						Customers.get(i).setUserName(newValue);
					else if(whatUpdate=="phone")
						Customers.get(i).setPhone(newValue);
					else if(whatUpdate=="numOfReq")
						Customers.get(i).setNumOfReq(Integer.parseInt(newValue));
					JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
					return "customer updated successfully";
				}
			}
			JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
			return "customer is not registered";
		
		
	}
	public String addProduct(Product p) {
			
				for(int i=0;i<Products.size();i++) {
					if(p.id==Products.get(i).id) {
						JOptionPane.showInternalMessageDialog(null, "product is already valid", "Error", JOptionPane.ERROR_MESSAGE);
						return "product is already valid";
					}
				}
				Products.add(p);
				JOptionPane.showInternalMessageDialog(null, "customer registered succefully", "success", JOptionPane.INFORMATION_MESSAGE);
				return "product added succefully";
			
		
	}
	public String deleteCustomer(String iD) {
		int index=-1;
			for(int i=0;i<Customers.size();i++) {
				if(!(iD.equals(Customers.get(i).id))) {
					JOptionPane.showInternalMessageDialog(null, "customer is not registered", "Error", JOptionPane.ERROR_MESSAGE);
					return "customer is not registered";
				}
				else {
					index=i;
				    break;}
			}
			
			Customers.remove(index);
			JOptionPane.showInternalMessageDialog(null, "customer deleted successfully", "success", JOptionPane.INFORMATION_MESSAGE);
			return "customer deleted successfully";
		
	}
	public String deleteProduct(String iD) {
		int index=-1;
		
			for(int i=0;i<Products.size();i++) {
				if(!(iD==Products.get(i).id)) {
					JOptionPane.showInternalMessageDialog(null, "product is not valid", "Error", JOptionPane.ERROR_MESSAGE);
					return "product is not valid";
				}
				else {
					 index=i;
					 break;}
			}
			Products.remove(index);
			JOptionPane.showInternalMessageDialog(null, "product deleted successfully", "success", JOptionPane.INFORMATION_MESSAGE);
			return "product deleted successfully";
		
	}
	public String updateProduct(String w, String iD, String n) {
		String id=iD;
		String whatUpdate=w;
		String newValue=n;
		
		
			for(int i=0;i<Products.size();i++) {
				if(id.equals(Products.get(i).id)) {
					if(whatUpdate == "name") 
						Products.get(i).setName(newValue);
					else if(whatUpdate=="price")
						Products.get(i).setPrice(Integer.valueOf(newValue));
					JOptionPane.showInternalMessageDialog(null, "product updated successfully", "success", JOptionPane.INFORMATION_MESSAGE);
					return "product updated successfully";
				}
			}
			JOptionPane.showInternalMessageDialog(null, "product is not valid", "Error", JOptionPane.ERROR_MESSAGE);
			return "product is not valid";
		
	}
	public void list() {
	    System.out.print("1- Register,Delete,Search,Update Customer "+"\n");
	    System.out.print("2- Register,Delete,Search,Update Product "+"\n");
	    System.out.print("3- add new order "+"\n");
	    System.out.print("4- Report for the system "+"\n");
	    System.out.print("5- Print total cash,paid,delivered items "+"\n");

}
	public boolean CustomerValid(String id) {
		int flag=0;
		for(int i=0;i<Customers.size();i++) {
			if(Customers.get(i).id==id)
				flag =1;
		}
		if(flag==1)
			return true;
		return false;
	}
	public boolean ProductValid(String id) {
		int flag=0;
		for(int i=0;i<Products.size();i++) {
			if(Products.get(i).id==id)
				flag =1;
		}
		if(flag==1)
			return true;
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
	public int diliveryPriceCalc(Customer c ) {
		String s=c.address;
		int deliveryPrice=12;
		if(s.toUpperCase().trim()=="DERALHATAB")
			deliveryPrice=20;
		else if(s.toUpperCase().trim()=="TELSTREET")
			deliveryPrice=15;
		else if(s.toUpperCase().trim()=="MREGSTREET")
			deliveryPrice=15;
		else if(s.toUpperCase().trim()=="STREER15")
			deliveryPrice=14;
		else if(s.toUpperCase().trim()=="ASERA")
			deliveryPrice=18;
		else if(s.toUpperCase().trim()=="DERSHARAF")
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
