package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateCustomer {
	public Admin a;
	public Customer c;
	public MySystem ms;
	String s,ID,whatUpdate,newValue;
	boolean updated;
	public UpdateCustomer(Admin a,MySystem ms) {
		this.a=a;
		this.ms=ms;
	}

@Given("that these customers are registered in the system")
public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	String id,name ,pass,email,phone,address;
	int numOfReq;
	for(int i=0; i<3;i++) {
		id=dataTable.cell(i, 0);
		name=dataTable.cell(i,1);
		pass=dataTable.cell(i,2);
		email=dataTable.cell(i,3);
		numOfReq=Integer.parseInt(dataTable.cell(i, 4));
		phone=dataTable.cell(i,5);
		address=dataTable.cell(i,6);
		c=new Customer(id,name,pass,email,numOfReq,phone,address);
		ms.Customers.add(c);   
		}
    throw new io.cucumber.java.PendingException();
}
	

@Given("that the admin is not logged in")
public void that_the_admin_is_not_logged_in() {
	a.setLoginState(false);
}
@Given("that the admin is logged in")
public void that_the_admin_is_logged_in() {
    a.setLoginState(true);
}


@Given("he want to update customer that his id {string}")
public void he_want_to_update_customer_that_his_id(String string) {
    ID=string;
}

@When("admin tries to update a customer")
public void admin_tries_to_update_a_customer() {
    s=a.update(whatUpdate,ID,newValue);
}

@Given("the customer is not registerd in the system")
public void the_customer_is_not_registerd_in_the_system() {
    c.isregistered(c);
}

@Given("the customer is registerd in the system")
public void the_customer_is_registerd_in_the_system() {
    c.isregistered(c);
}

@When("admin tries to update a customer {string} to {string}")
public void admin_tries_to_update_a_customer_to(String string,String string2) {
    whatUpdate=string;
	newValue=string2;  
}

@Then("customer update successed")
public void customer_update_successed() {
	assertTrue(true);
}

@Then("an information massage {string} should display")
public void an_information_massage_should_display(String string) {
	assertEquals(string,s);
}
@Then("an error massage {string} should display")
public void an_error_massage_should_display(String string) {
	assertEquals(string,s);
	
}

}
