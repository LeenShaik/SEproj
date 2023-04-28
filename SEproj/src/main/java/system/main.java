package system;

import java.io.Console;

public class main {

	public static void main(String[] args) {
		MySystem system =new MySystem();
		
		Customer customer=new Customer("123456","faihaa odeh","faihaa.odeh20@gmail.com",5,"0599773638","DerAlhatab");
		system.Customers.add(customer);
		customer=new Customer("113456","lana jaber","s11923877@stu.najah.edu",2,"0595721772","rafidia");
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
		String username,pass;char [] password;
	    Console console = System.console();
	    System.out.println("Enter username:");
	    username = console.readLine();
	    System.out.println("Enter password:");
	    password = console.readPassword();
	    pass=new String(password);
	    if(admin.login(username, pass)) {
	    	System.out.println("welcom leen, choose what you want to do");
	    	system.list();
	    	String choice=console.readLine();
	    	char ch;
	    	if(choice =="1")
	    		ch='1';
	    	else if(choice == "2")
	    		ch='2';
	    	else if(choice == "3")
	    		ch='3';
	    	else if(choice == "4")
	    		ch='4';
	    	else if(choice == "5")
	    		ch='5';
	    	else {
	    		System.out.println("plz insert valid choice !! ");
	    		choice=console.readLine();
	    	}
	    	
	    		
	    		
	    	
	    	switch(ch) {
	    	case '1':
	    		System.out.println("Enter A for add , D for delete and U for update customer");
	    		System.out.println("You can enter B to back to the list !");
	    		String s =console.readLine();
	    		if(s=="A") {
	    			String  id,name,email,phone,address;
		    		int numOfReq=0;
	    			System.out.println("insert his id");
	    			id=console.readLine();
	    			System.out.println("insert his name");
	    			name=console.readLine();
	    			System.out.println("insert his email");
	    			email=console.readLine();
	    			System.out.println("insert his phone");
	    			phone=console.readLine();
	    			System.out.println("insert his address");
	    			address=console.readLine();
	    			Customer c=new Customer(id,name,email,numOfReq,phone,address);
	    			system.Customers.add(c);
	    		}
	    		else if(s=="D") {
	    			System.out.println("insert the id for customer to delete him");
	    			String id=console.readLine();
	    			system.deleteCustomer(id);
	    		}
	    		else if(s=="U") {
	    			System.out.println("insert what you want to update ");
	    			String whatUpdate=console.readLine();
	    			System.out.println("insert the id for customer ");
	    			String id=console.readLine();
	    			System.out.println("insert the new value");
	    			String newValue=console.readLine();
	    			system.update(whatUpdate, id, newValue);
	    			
	    		}
	    		else if (s=="B") {
	    			system.list();
	    			choice=console.readLine();
	    		}
	    		else {
	    			System.out.println("plz enter valid value!");
	    			s=console.readLine();
	    		}
	    		break;
	    	case '2':
	    		System.out.println("Enter A for add , D for delete and U for update product");
	    		System.out.println("You can enter B to back to the list !");
	    		String s1 =console.readLine();
	    		if(s1=="A") {
	    			String id,name;
	    			int price;
	    			System.out.println("insert its id");
	    			id=console.readLine();
	    			System.out.println("insert its name");
	    			name=console.readLine();
	    			System.out.println("insert its price");
	    			price=Integer.parseInt(console.readLine());
	    			Product p=new Product(id,name,price);
	    			system.Products.add(p);
	    		}
	    		else if(s1=="D") {
	    			System.out.println("insert the id for product to delete it");
	    			String id=console.readLine();
	    			system.deleteProduct(id);
	    		}
	    		else if(s1=="U") {
	    			System.out.println("insert what you want to update");
	    			String whatUpdate=console.readLine();
	    			System.out.println("insert the id for product");
	    			String id=console.readLine();
	    			System.out.println("insert the new value");
	    			String newValue=console.readLine();
	    			system.updateProduct(newValue, id, username);
	    			
	    		}
	    		else if (s1=="B") {
	    			system.list();
	    			choice=console.readLine();
	    		}
	    		else {
	    			System.out.println("plz enter valid value!");
	    			s1=console.readLine();
	    		}
	    		break;
	    	case '3':
	    		String oId,cId,pId,wId;
	    		int numOfOrder,deliveryPrice,productPrice;
	    		Status status=Status.WAITING;
	    		oId=Integer.toString( system.Orders.size() +1);
	    		System.out.println("insert id of the customer who has this order");
	    		cId=console.readLine();
	    		if(! (system.CustomerValid(cId))) {
	    			System.out.println("this id is not exist! plz enter exist id!");
	    			cId=console.readLine();
	    		}
	    		System.out.println("insert what's the  product he want to clean");
	    		system.productList();
	    		pId=console.readLine();
	    		if(!(system.ProductValid(pId))) {
	    			System.out.println("this id is not exist! plz enter exist id!");
    			    pId=console.readLine();}
	    		System.out.println("insert number of products he want");
	    		numOfOrder=Integer.valueOf(console.readLine());
	    		for(int i=0;i<system.Customers.size();i++) {
	    			if(system.Customers.get(i).id==cId) {
	    				deliveryPrice=system.diliveryPriceCalc(system.Customers.get(i));
	    				for(int j=0;j<system.Products.size();j++) {
	    					if(system.Products.get(j).id==pId)
	    						productPrice=system.productPriceCalc(system.Customers.get(i),system.Products.get(j), numOfOrder);
	    						
	    				}
	    			}
	    		}
	    			//////1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	    		
	    		
	    	}
	    }
		
		
		
		

	}

}
