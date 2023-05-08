package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCustomer {

	public Admin a;
	public Customer c;
	public MySystem ms;
	String s,id;

	public SearchCustomer(Admin a,MySystem ms,Customer c) {
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
		ms.Customers.add(c);   
		}
    throw new io.cucumber.java.PendingException();
}
@Given("that the admin is logged in")
public void that_the_admin_is_logged_in() {
    a.setLoginState(true);
}

@When("admin tries to search for id {string}")
public void admin_tries_to_search_for_id(String string) {
	id=string;
	s=a.search(id,ms);
    
}

@Then("a {string} should display")
public void a_should_display(String string) {
	assertEquals(string,s);

}

}
