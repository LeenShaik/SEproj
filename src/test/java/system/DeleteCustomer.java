package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteCustomer {
	public Admin a;
	public Customer c;
	public MySystem ms;
	String s ,id;
	public DeleteCustomer(Admin a,MySystem ms,Customer c) {
		this.a=a;
		this.ms=ms;
		this.c=c;
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



@Given("admin want to delete customer that his id {string}")
public void admin_want_to_delete_customer_that_his_id1(String string) {
    id=string;
}

@When("admin tries to delete a customer")
public void admin_tries_to_delete_a_customer() {
	s=ms.deleteCustomer(id);

}

@Then("a msg{string} should display")
public void a_msg_should_display(String string) {
	assertEquals(string,s);

}



	
	
	
}
