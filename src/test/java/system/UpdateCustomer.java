package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateCustomer {
	public Admin a=new Admin();
	public MySystem ms=new MySystem();
	String ID,whatUpdate,newValue;
	boolean check;
	

@Given("that these customers are registered in the system")
public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {

	ms.customers.add(new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
	ms.customers.add(new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
	ms.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
	 
}
	


@Given("that admin want to update customer that his id {string}")
public void that_admin_want_to_update_customer_that_his_id(String string) {
    ID=string;
}

@When("admin tries to update a customer {string} to {string}")
public void admin_tries_to_update_a_customer_to(String string,String string2) {
    whatUpdate=string;
	newValue=string2;  
	check=ms.update(whatUpdate,ID,newValue);
}

@Then("customer updated faild")
public void customer_updated_faild() {
	assertTrue(!check);
}
@Then("customer updated successfully")
public void customer_updated_successfully() {
	assertTrue(check);
}


}
