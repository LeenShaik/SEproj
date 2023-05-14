package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteCustomer {

	public MySystem system=new MySystem();
	String id;
	int before,after;


@Given("this customers are registered in the system")
public void this_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	system.customers.add(new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
	system.customers.add(new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
	system.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
}
@Given("admin want to delete customer that his id {string}")
public void admin_want_to_delete_customer_that_his_id1(String string) {
	before=system.customers.size();
    id=new String(string);
}
@When("admin tries to delete a customer")
public void admin_tries_to_delete_a_customer() {

	system.deleteCustomer(id);
	after=system.customers.size();
}

@Then("customer deleted faild")
public void customer_deleted_faild() {
	assertEquals(before,after);

}
@Then("customer deleted successfully")
public void customer_deleted_successfully() {
	assertEquals(before-1,after);

}
	
}
