package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCustomer {
	public MySystem system=new MySystem();
	String s,id;
	boolean check;
	
	


@Given("customers registered in the system")
public void customers_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	system.customers.add(new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
	system.customers.add(new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
	system.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
	
}


@When("admin tries to search for customer id {string}")
public void admin_tries_to_search_for_customer_id(String string) {
	id=string;
	system.search(id);
	check=system.customerValid(id);
    
}


@Then("customer search success")
public void customer_search_success() {
	assertTrue(check);
}
@Then("customer search faild")
public void customer_search_faild() {
	assertTrue(!check);

}

}
