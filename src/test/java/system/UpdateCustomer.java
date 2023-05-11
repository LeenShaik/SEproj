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
	public UpdateCustomer(Admin a,MySystem ms,Customer c) {
		this.a=a;
		this.ms=ms;
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
		ms.customers.add(c);   
		}
    throw new io.cucumber.java.PendingException();
}
	

@Given("that the admin is logged in")
public void that_the_admin_is_logged_in() {
    a.setLoginState(true);
}


@Given("he want to update customer that his id {string}")
public void he_want_to_update_customer_that_his_id(String string) {
    ID=string;
}

@When("admin tries to update a customer {string} to {string}")
public void admin_tries_to_update_a_customer_to(String string,String string2) {
    whatUpdate=string;
	newValue=string2;  
	s=ms.update(whatUpdate,ID,newValue);
}

@Then("this msg {string} should display")
public void this_msg_should_display(String string) {
	assertEquals(string,s);
}


}
