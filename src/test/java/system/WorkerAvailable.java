package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkerAvailable {
	Order o =new Order("8","987654","4","113",1,0,20);
	MySystem system=new MySystem();
	Admin a = new Admin();
	String id;
	boolean s;
	@Given("that these worker are registered in the system")
	public void that_these_worker_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {

		system.workers.add(new Worker("123","hamza ahmad","0598937949","Rafedia",true));
		system.workers.add(new Worker("113","taher yaseen","0599894568","Rafedia",true));
		system.workers.add(new Worker("223","ayman mohammed","059378568","makhfia",true));
	}

	@Given("that there is order with id {string}")
	public void that_there_is_order_with_id(String string) {
	    id=string;
	}

	@When("admin tries to distribute the order to the worker")
	public void admin_tries_to_distribute_the_order_to_the_worker() {
	    s=!a.distribute(system,o);
		o.setStatus(Status.INTREATMENT);

	}

	@When("the worker is free")
	public void the_worker_is_free() {
	   	}


	@Then("available worker received the order")
	public void available_worker_received_the_order() {
	  assertTrue(s);
	}

	@Then("the status change to intreatment")
	public void the_status_change_to_intreatment() {
	    assertEquals(Status.INTREATMENT,o.getStatus());

	}
	
	
}
