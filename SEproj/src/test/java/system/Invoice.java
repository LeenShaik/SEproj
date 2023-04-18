package system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Invoice {
	
	Customer c;
    MySystem ms;
    Product p;
    Order o;
	String s,address,productName;
	int total;
	public Invoice(MySystem ms ,Customer c ,Product p ,Order o) {
		this.c=c;
		this.ms=ms;
		this.p=p;
		o.cId=c.id;
		o.pId=p.id;
		
		
	}
	@Given("that these customers are registered in the system")
	public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String id,name,email,phone,address;
		int numOfReq;
		for(int i=0; i<3;i++) {
			id=dataTable.cell(i, 0);
			name=dataTable.cell(i,1);
			email=dataTable.cell(i,2);
			numOfReq=Integer.parseInt(dataTable.cell(i, 3));
			phone=dataTable.cell(i,4);
			address=dataTable.cell(i,5);
			c=new Customer(id,name,email,numOfReq,phone,address);
			ms.Customers.add(c);   
			}
	    throw new io.cucumber.java.PendingException();
	}

	@Given("that the customer with id {string}")
	public void that_the_customer_with_id(String string) {
	   if(c.id==string) {
		   address=c.address;
	   }
	}

	@Given("he want to clean {string}")
	public void he_want_to_clean(String string) {
	    productName=string;
	}

	@Then("the price is {int}")
	public void the_price_is(Integer int1) {
	    total =o.diliveryPriceCalc(c)+o.productPriceCalc(c,p);
	}

	@Then("the msg {string} {int} printed")
	public void the_msg_printed(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
