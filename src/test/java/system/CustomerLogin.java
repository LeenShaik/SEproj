package system;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CustomerLogin {
	public Customer c;
	public MySystem s;
	String username,pass;

	public CustomerLogin(MySystem s) {
		this.s=s;
	}


@Given("that these customer are regesterd in the system")
public void that_these_customer_are_regesterd_in_the_system(io.cucumber.datatable.DataTable dataTable) {
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
		s.Customers.add(c);   
		}
    throw new io.cucumber.java.PendingException();
}


@Given("that the customer is not logged in")
public void that_the_customer_is_not_logged_in() {
    c.setLoginState(false);
}

@Given("the customer is already registerd")
public void the_customer_is_already_registerd() {
    c.isregistered(c);
}

@Given("the customer inter email {string} and password {string}")
public void the_customer_inter_email_and_password(String string, String string2) {
    username=string;
    pass=string2;
    
}

@Then("the customer login succeeds")
public void the_customer_login_succeeds() {
	 assertTrue(c.login(username,pass));
}

@Then("the customer is logged in")
public void the_customer_is_logged_in() {
	assertTrue(c.getLoginState());
}

@Then("the customer login fails")
public void the_customer_login_fails() {
	assertFalse(c.login(username,pass));
}

@Then("the customer is not logged in")
public void the_customer_is_not_logged_in() {
	assertFalse(c.getLoginState());
}












}
	
