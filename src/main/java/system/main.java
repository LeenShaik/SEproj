package system;


import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class main {

	public static void main(String[] args) {
		MySystem system =new MySystem();
	
		

		Customer customer=new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab");
		system.Customers.add(customer);
		customer=new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia");
		system.Customers.add(customer);
		customer=new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia");
		system.Customers.add(customer);
		
		Product product=new Product("0","CARPET minimum than 9                    ",15);
		system.Products.add(product);
		product=new Product("1","CARPET greater than 9 and smaller than 16",20);
		system.Products.add(product);
		product=new Product("2","CARPET greater than 16",30);
		system.Products.add(product);
		product=new Product("3","SINGLECOVER",13);
		system.Products.add(product);
		product=new Product("4","COUPLECOVER",20);
		system.Products.add(product);
		product=new Product("5","CURTAIN",8);
		system.Products.add(product);
		
		Worker worker=new Worker("123","hamza ahmad","0598937949","Rafedia",true);
		system.Workers.add(worker);
		worker=new Worker("113","taher yaseen","0599894568","Rafedia",true);
		system.Workers.add(worker);
		worker=new Worker("223","ayman mohammed","059378568","makhfia",true);
		system.Workers.add(worker);
		
		Order order=new Order("1","123456","0","123",1,20,15,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("2","123456","0","123",1,20,15,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("3","123456","0","123",1,20,15,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("4","123456","2","445",1,20,30,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("5","123456","0","445",1,20,13,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("6","113456","5","123",1,12,8,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("7","113456","4","113",1,12,20,Status.COMPLETE);
		system.Orders.add(order);
		order=new Order("8","987654","4","113",1,0,20,Status.COMPLETE);
		system.Orders.add(order);
		
		Admin admin =new Admin ();
		String username,password;
		Scanner con = new Scanner(System.in);
	    System.out.println("Enter username:");
	    username = con.nextLine();
	    System.out.println("Enter password:");
	    password = con.nextLine();
	    
	    if(admin.login(username, password)) {
	    	system.list();
	    	while(true) {
	    	String choice=con.nextLine();
	    	
	    	if(choice.equals("1")) {
	    		System.out.println("Enter A for add , D for delete and U for update customer");
	    		System.out.println("You can enter B to back to the list !");
	    		while(true) {
	    		String s =con.nextLine();
	    		if(s.equals("A")) {
	    			String  id,name,email,phone,address;
	    			int numOfReq=0;
	    			System.out.println("insert his id");
	    			id=con.nextLine();
	    			System.out.println("insert his name");
	    			name=con.nextLine();
	    			System.out.println("insert his email");
	    			email=con.nextLine();
	    			System.out.println("insert his phone");
	    			phone=con.nextLine();
	    			System.out.println("insert his address");
	    			address=con.nextLine();
	    			Customer c=new Customer(id,name,email,numOfReq,phone,address);
	    			String pr = system.register(c);
	    			System.out.println(pr);
	    			continue;
	    					}
	    		else if(s.equals("D")) {
	    			System.out.println("insert the id for customer to delete him");
	    			String id=con.nextLine();
	    			String pr=system.deleteCustomer(id);
	    			System.out.println(pr);
	    			continue;
	    						}
	    		else if(s.equals("U")) {
	    			System.out.println("insert what you want to update ");
	    			String whatUpdate=con.nextLine();
	    			System.out.println("insert the id for customer ");
	    			String id=con.nextLine();
	    			System.out.println("insert the new value");
	    			String newValue=con.nextLine();
	    			String pr=system.update(whatUpdate, id, newValue);
	    			System.out.println(pr);
	    			continue;
    			
	    						}
	    		else if (s.equals("B")) {
	    			system.list();
	    			break;
	    						}
	    		else {
	    			System.out.println("plz enter valid value!");
	    			continue;
	    			 }
	    		}
	    		continue;
	    		}
	    	else if(choice.equals("2")) {
	    		System.out.println("Enter A for add , D for delete and U for update product");
	    		System.out.println("You can enter B to back to the list !");
	    		while(true) {
	    		String s1 =con.nextLine();
	    		if(s1.equals("A")) {
	    			String id,name;
	    			int price;
	    			System.out.println("insert its id");
	    			id=con.nextLine();
	    			System.out.println("insert its name");
	    			name=con.nextLine();
	    			System.out.println("insert its price");
	    			price=Integer.parseInt(con.nextLine());
	    			Product p=new Product(id,name,price);
	    			String pr =system.addProduct(p);
	    			System.out.println(pr);
	    			continue;
	    		}
	    		else if(s1.equals("D")) {
	    			System.out.println("insert the id for product to delete it");
	    			String id=con.nextLine();
	    			String pr =system.deleteProduct(id);
	    			System.out.println(pr);
	    			continue;
	    		}
	    		else if(s1.equals("U")) {
	    			System.out.println("insert what you want to update");
	    			String whatUpdate=con.nextLine();
	    			System.out.println("insert the id for product");
	    			String id=con.nextLine();
	    			System.out.println("insert the new value");
	    			String newValue=con.nextLine();
	    			String pr =system.updateProduct(newValue, id, username);
	    			System.out.println(pr);
	    			continue;
	    			
	    		}
	    		else if (s1.equals("B")) {
	    			system.list();
	    			break;
	    		}
	    		else {
	    			System.out.println("plz enter valid value!");
	    			continue;
	    		}}
	    		continue;
	    	}
	    	else if (choice.equals("3")) {
	    		String oId,cId,pId,wId="123";
	    		int numOfOrder;
	    		oId=Integer.toString( system.Orders.size());
	    		System.out.println("insert id of the customer who has this order");
	    		cId=con.nextLine();
	    		if(! (system.CustomerValid(cId))) {
	    			System.out.println("this customer is not exist! plz enter exist id!");
	    			cId=con.nextLine();
	    		}
	    		System.out.println("insert what's the  product he want to clean");
	    		system.productList();
	    		pId=con.nextLine();
	    		if(!(system.ProductValid(pId))) {
	    			System.out.println("this product is not exist! plz enter exist id!");
    			    pId=con.nextLine();}
	    		System.out.println("insert number of products he want");
	    		numOfOrder=Integer.valueOf(con.nextLine());
	    		int wflag=0;
	    		for(int k=0;k<system.Workers.size();k++) {
	    			if(system.Workers.get(k).isFree==true) {
	    				wId=system.Workers.get(k).id;
	    				system.Workers.get(k).setIsFree(false);
	    				wflag=k;
	    				break;
	    			}}
	    		int indexc=0,indexp=0;
	    		System.out.println("Does he want us to deliver the order? , just write Y for yes  or N for no");
	    		String dflag=con.nextLine();
	    		String email="s11923877@stu.najah.edu";
	    		for(int i=0;i<system.Customers.size();i++) {
	    			if(system.Customers.get(i).id.equals(cId)) {
	    				email=system.Customers.get(i).email;
	    				indexc=i;
	    				for(int j=0;j<system.Products.size();j++) {
	    					if(system.Products.get(j).id.equals(pId))
	    						indexp=j;
	    						
	    						
	    				}
	    			}
	    		}
	    		int deliveryPrice=system.diliveryPriceCalc(system.Customers.get(indexc));
	    		
				int productPrice=system.productPriceCalc(system.Customers.get(indexc),system.Products.get(indexp), numOfOrder);
				
				if (dflag.equals("N")) {
					deliveryPrice=0;
				}
				

	    		Order o=new Order(oId,cId,pId,wId,numOfOrder,deliveryPrice,productPrice,Status.INTREATMENT);
	    		
	    		int invoice=deliveryPrice+productPrice;
    			System.out.println("His invoice is :"+invoice);
	    		System.out.println("Status for order now is in treatment,when worker finish insert C for complete ");
	    		while(true) {
	    		String stat=con.nextLine();
	    		if(stat.equals("C")) {
	    			o.setStatus(Status.COMPLETE);
	    			//system.sendGmail(email);
	    			system.Orders.add(o);
	    			system.Customers.get(indexc).numOfReq+=1;
	    			system.Workers.get(wflag).setIsFree(true);
	    			System.out.println("order complete ...");
	    			
	    			break;
	    		}
	    		else  {
	    			System.out.println("Insert valid status !");
	    			continue;
	    		}
	    		}
	    		
	    		continue;
	    	}
	    	else if(choice.equals("4")) {
	    		system.Report();
	    		continue;
	    	}
	    	else if(choice.equals("5")) {
	    		System.out.println("Insert C fot total cash ,P for total paid and Dfor delivered items") ; 
	    		System.out.println("You can enter B to back to the list !");
	    		while(true) {
	    			String s2=con.nextLine();
	    			if(s2.equals("C")) {
	    				int c = system.totalCash();
	    				System.out.println("Total cash = "+c);
	    				continue;
	    			}
	    			else if(s2.equals("P")) {
	    				int p = system.totalPaid();
	    				System.out.println("Total paid = "+ p);
	    				continue;
	    			}
	    			else if(s2.equals("D")){
	    				int d = system.totaldelivery();
	    				System.out.println("Total delivered item = "+d);
	    				continue;
	    			}
	    			else if(s2.equals("B")) {
	    				system.list();
	    				break;
	    			}
	    			else {
		    			System.out.println("plz enter valid value!");
		    			continue;
		    		}
	    					
	    		}
	    		
	    		continue;
	    	}
	    	else if(choice.equals("6")) {
	    		System.out.println("Logout successfully");
	    		admin.logOut();
	    		break;
	    	}
	    	else {
	    		System.out.println("plz insert valid choice !! ");
	    		continue;
	    	}
	    	}
	   
	    	
	    }
		
		
		
		

	}

}
