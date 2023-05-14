package system;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Report {
	MySystem system=new MySystem();
	boolean b;
	
	

	@Given("that this customers are registered in the system")
	public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		system.customers.add(new Customer("id1","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
		system.customers.add(new Customer("id2","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
		system.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
	}

	@Given("these products are valid in the system")
	public void these_products_are_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		system.products.add(new Product("0","CARPET minimum than 9",15));
		system.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
		system.products.add(new Product("2","CARPET greater than 16",30));
		system.products.add(new Product("3","SINGLECOVER",13));
		system.products.add(new Product("4","COUPLECOVER",20));
		system.products.add(new Product("5","CURTAIN",8));
	}

	@Given("that this worker are registered in the system")
	public void that_this_worker_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {

		system.workers.add(new Worker("123","hamza ahmad","0598937949","Rafedia",true));
		system.workers.add(new Worker("113","taher yaseen","0599894568","Rafedia",true));
		system.workers.add(new Worker("223","ayman mohammed","059378568","makhfia",true));
	}

	@When("admin tries to show the report")
	public void admin_tries_to_show_the_report() {
	    b = system.report();
	}

	@Then("report will display")
	public void report_will_display() {
	    assertTrue(b);
	}
}
