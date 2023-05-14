package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkerAvailable {
	Order o =new Order("8","987654","4","113",1,0,20);
	MySystem ms=new MySystem();
	Admin a = new Admin();
	String id;
	boolean s;
	
	public void WorkerAvailable(Order o,MySystem ms,Admin a) {
		this.o=o;
		this.a=a;
		this.ms=ms;
	}
	@Given("that these worker are registered in the system")
	public void that_these_worker_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String id,name,phone,address,free;
		boolean isFree;
		
		for(int i=0; i<4;i++) {
			id=dataTable.cell(i, 0);
			name=dataTable.cell(i,1);
			phone=dataTable.cell(i,2);
			address=dataTable.cell(i, 3);
			free=dataTable.cell(i,4);
			if(free.equals("true"))
				isFree=true;
			else 
				isFree=false;
			//w=new Worker(id,name,phone,address,isFree);
			//ms.workers.add(w);   
			}
	  //  throw new io.cucumber.java.PendingException();
	}

	@Given("that there is order with id {string}")
	public void that_there_is_order_with_id(String string) {
	    id=string;
	}

	@When("admin tries to distribute the order to the worker")
	public void admin_tries_to_distribute_the_order_to_the_worker() {
	    s=!a.distribute(ms,o);
		o.setStatus(Status.INTREATMENT);

	}

	@When("the worker is free")
	public void the_worker_is_free() {
	   	}

	@Then("msg {string} display")
	public void msg_display(String string) {
	    assertEquals(s,string);
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
