package system;


import java.util.Scanner;

public class MyMain {
	final String id1="123456";
	final String id2="113456";
	final static String back="You can enter B to back to the list !";
	
	public static void list() {
	    System.out.print("1- Add,Delete,Search,Update Customer "+"\n");
	    System.out.print("2- Add,Delete,Search,Update Product "+"\n");
	    System.out.print("3- add new order "+"\n");
	    System.out.print("4- Report for the system "+"\n");
	    System.out.print("5- Print total cash,paid,delivered items "+"\n");
	    System.out.print("6- Logout "+"\n");

}
	public static void productList() {
		System.out.println("0-if he want to clean CARPET minimum than 9");
		System.out.println("1-if he want to clean CARPET greater than 9 and smaller than 16");
		System.out.println("2-if he want to clean CARPET greater than 16");
		System.out.println("3-if he want to clean SINGLE COVER");
		System.out.println("4-if he want to clean COUPLE COVER");
		System.out.println("5-if he want to clean CURTAIN");

	}
	
	public static void main(String[] args) {
		MySystem system =new MySystem();
	
		

		Customer customer=new Customer("id1","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab");
		system.customers.add(customer);
		customer=new Customer("id2","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia");
		system.customers.add(customer);
		customer=new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia");
		system.customers.add(customer);
		
		Product product=new Product("0","CARPET minimum than 9                    ",15);
		system.products.add(product);
		product=new Product("1","CARPET greater than 9 and smaller than 16",20);
		system.products.add(product);
		product=new Product("2","CARPET greater than 16",30);
		system.products.add(product);
		product=new Product("3","SINGLECOVER",13);
		system.products.add(product);
		product=new Product("4","COUPLECOVER",20);
		system.products.add(product);
		product=new Product("5","CURTAIN",8);
		system.products.add(product);
		
		Worker worker=new Worker("123","hamza ahmad","0598937949","Rafedia",true);
		system.workers.add(worker);
		worker=new Worker("113","taher yaseen","0599894568","Rafedia",true);
		system.workers.add(worker);
		worker=new Worker("223","ayman mohammed","059378568","makhfia",true);
		system.workers.add(worker);
		
		Order order=new Order("1","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("2","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("3","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("4","id1","2","445",1,20,30);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("5","id1","0","445",1,20,13);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("6","id1","5","123",1,12,8);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("7","id2","4","113",1,12,20);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("8","987654","4","113",1,0,20);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		
		Admin admin =new Admin ();
		String username;
		String password;
		Scanner con = new Scanner(System.in);
	    System.out.println("Enter username:");
	    username = con.nextLine();
	    System.out.println("Enter password:");
	    password = con.nextLine();
	    
	    if(admin.login(username, password)) {
	    	
	    	list();
	    	while(true) {
	    	String choice=con.nextLine();
	    	
	    	if(choice.equals("1")) {
	    		System.out.println("Enter A for add , D for delete and U for update customer");	    		
	    		System.out.println(back);
	    		
	    		while(true) {
	    		String s =con.nextLine();
	    		if(s.equals("A")) {
	    			String  id;
	    			String name;
	    			String email; 
	    			String phone;
	    			String address;
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
	    			list();
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
	    		System.out.println(back);
	    		while(true) {
	    		String s1 =con.nextLine();
	    		if(s1.equals("A")) {
	    			String id;
	    			String name;
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
	    			list();
	    			break;
	    		}
	    		else {
	    			System.out.println("plz enter valid value!");
	    			continue;
	    		}}
	    		continue;
	    	}
	    	else if (choice.equals("3")) {
	    		String oId;
	    		String cId;
	    		String pId;
	    		String wId="123";
	    		int numOfOrder;
	    		oId=Integer.toString( system.orders.size());
	    		System.out.println("insert id of the customer who has this order");
	    		cId=con.nextLine();
	    		if(! (system.customerValid(cId))) {
	    			System.out.println("this customer is not exist! plz enter exist id!");
	    			cId=con.nextLine();
	    		}
	    		System.out.println("insert what's the  product he want to clean");
	    		productList();
	    		pId=con.nextLine();
	    		if(!(system.productValid(pId))) {
	    			System.out.println("this product is not exist! plz enter exist id!");
    			    pId=con.nextLine();}
	    		System.out.println("insert number of products he want");
	    		numOfOrder=Integer.valueOf(con.nextLine());
	    		int wflag=0;
	    		for(int k=0;k<system.workers.size();k++) {
	    			if(system.workers.get(k).isFree) {
	    				wId=system.workers.get(k).id;
	    				system.workers.get(k).setIsFree(false);
	    				wflag=k;
	    				break;
	    			}}
	    		int indexc=0;int indexp=0;
	    		System.out.println("Does he want us to deliver the order? , just write Y for yes  or N for no");
	    		String dflag=con.nextLine();
	    		for(int i=0;i<system.customers.size();i++) {
	    			if(system.customers.get(i).id.equals(cId)) {
	    				email=system.customers.get(i).email;
	    				indexc=i;
	    				for(int j=0;j<system.products.size();j++) {
	    					if(system.products.get(j).id.equals(pId))
	    						indexp=j;
	    						
	    						
	    				}
	    			}
	    		}
	    		int deliveryPrice=system.diliveryPriceCalc(system.customers.get(indexc));
	    		
				int productPrice=system.productPriceCalc(system.customers.get(indexc),system.products.get(indexp), numOfOrder);
				
				if (dflag.equals("N")) {
					deliveryPrice=0;
				}
				

	    		Order o=new Order(oId,cId,pId,wId,numOfOrder,deliveryPrice,productPrice);
	    		o.setStatus(Status.INTREATMENT);
	    		
	    		int invoice=deliveryPrice+productPrice;
    			System.out.println("His invoice is :"+invoice);
	    		System.out.println("Status for order now is in treatment,when worker finish insert C for complete ");
	    		while(true) {
	    		String stat=con.nextLine();
	    		if(stat.equals("C")) {
	    			o.setStatus(Status.COMPLETE);
	    			system.orders.add(o);
	    			system.customers.get(indexc).numOfReq+=1;
	    			system.workers.get(wflag).setIsFree(true);
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
	    		int i;
	    		System.out.println("These customers are registered in the system");
	    		System.out.printf("%-20s|%-20s|%-25s|%-20s|%-10s|%-20s|%n","Id","Name","email","Number of request","Phone","address");
	    		for ( i=0;i<system.customers.size();i++) {	                
	                System.out.printf("%-20s|%-20s|%-25s|%-20d|%-10s|%-20s|%n",system.customers.get(i).id,system.customers.get(i).name,system.customers.get(i).email,system.customers.get(i).numOfReq,system.customers.get(i).phone,system.customers.get(i).address);
	    		}
	    		i=0;
	    		System.out.println("_____________________________________________________________________________________________________________"+"\n");
	    		System.out.println("These products are valid in the system");
	    		System.out.printf("%-10s|%-42s|%-10s|%n","Id","Name","price");
	    		for (i=0;i<system.products.size();i++) {
	                
	                System.out.printf("%-10s|%-42s|%-10d|%n",system.products.get(i).id,system.products.get(i).name,system.products.get(i).price);	
	    		}
	    		i=0;
	    		System.out.println("_____________________________________________________________________________________________________________"+"\n");
	    		System.out.println("These workers works in the system");
	    		System.out.printf("%-10s|%-20s|%-11s|%-15s|%n","Id","Name","Phone","address");
	    		for(i=0;i<system.workers.size();i++) {	                 
	                 System.out.printf("%-10s|%-20s|%-11s|%-15s|%n",system.workers.get(i).id,system.workers.get(i).name,system.workers.get(i).phone,system.workers.get(i).address);	    			
	    		}
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
	    				list();
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

