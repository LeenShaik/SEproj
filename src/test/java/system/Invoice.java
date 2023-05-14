package system;


import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Invoice {
    MySystem system=new MySystem();
    Product p;
    Order o;
    String cid,pid;
    int cindex=0,pindex=0;

	@Given("these customers are registered in the system")
	public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		system.customers.add(new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
		system.customers.add(new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
		system.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
		

		system.products.add(new Product("0","CARPET minimum than 9",15));
		system.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
		system.products.add(new Product("2","CARPET greater than 16",30));
		system.products.add(new Product("3","SINGLECOVER",13));
		system.products.add(new Product("4","COUPLECOVER",20));
		system.products.add(new Product("5","CURTAIN",8));
	}

	@Given("that the customer with id {string}")
	public void that_the_customer_with_id(String string) {
	 cid=string;
	 for(int i =0;i<system.customers.size();i++) {
			if(system.customers.get(i).id .equals(cid)) {
				cindex=i;
				break;
				}
			
		}
	}

	
	@Given("he want to clean product with id {string}")
	public void he_want_to_clean_product_with_id(String string) {
	   pid=string;
	   for(int i =0;i<system.products.size();i++) {
			if(system.products.get(i).id .equals(pid)) {
				pindex=i;
				break;}
		}
	}


	@Then("the price is {int}")
	public void the_price_is(int int1) {
		
		int expected=int1;
		int price=system.productPriceCalc(system.customers.get(cindex),system.products.get(pindex), 1);
		int d = system.diliveryPriceCalc(system.customers.get(cindex));
		int total=price+d;
		assertEquals(expected,total);
	
	}


	
}
