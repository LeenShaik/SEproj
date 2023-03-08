package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterCustomer {
	public Admin a;
	public Customer c;
	public MySystem ms;
	String s;
	int before,after;
	public RegisterCustomer(Admin a,MySystem ms) {
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
	before=ms.Customers.size();
    throw new io.cucumber.java.PendingException();
}

@Given("that the admin is not logged in")
public void that_the_admin_is_not_logged_in() {
	a.setLoginState(false);
}
@When("admin tries to register a customer")
public void admin_tries_to_register_a_customer() {
	s=a.register(c,ms);
	after=ms.Customers.size();
}

@Then("an error massage {string} should display")
public void an_error_massage_should_display(String string) {
	assertEquals(string,s);
	assertEquals(before, after);
}

@Given("that the admin is logged in")
public void that_the_admin_is_logged_in() {
    a.setLoginState(true);
}

@Given("there is a customer with ID {string} , name {string} ,pass {string}, email {string},numOfReq {int} ,phone {string},address {string}")
public void there_is_a_customer_with_id_name_pass_email_num_of_req_phone_address(String string, String string2, String string3, String string4, Integer int1, String string5, String string6) {
	c=new Customer(string,string2,string3,string4,int1,string5,string6);
}

@Then("an information message {string} should displayed")
public void an_information_message_should_displayed(String string) {
	assertEquals(string,s);
	assertEquals(before+1, after);
}
}
