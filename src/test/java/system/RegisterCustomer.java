package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterCustomer {
	public Customer c;
	public MySystem system=new MySystem();
	boolean check;
	String id;
	
@Given("that the customers registered in the system")
public void that_the_customers_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	system.customers.add(new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
	system.customers.add(new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
	system.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
	
}



@When("admin tries to register a customer")
public void admin_tries_to_register_a_customer() {
	check=system.register(c);
}


@Given("there is a customer with ID {string} , name {string} , email {string},numOfReq {int} ,phone {string},address {string}")
public void there_is_a_customer_with_id_name_pass_email_num_of_req_phone_address(String string, String string2, String string4, Integer int1, String string5, String string6) {
	c=new Customer(string,string2,string4,int1,string5,string6);
	id=string;
	
}


@Then("customer registered successfully")
public void customer_registered_successfully () {
	
	assertTrue(check);
}

@Then("customer registered faild")
public void customer_registered_faild() {
	assertTrue(!check);
}
}
