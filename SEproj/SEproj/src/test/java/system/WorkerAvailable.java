package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkerAvailable {
	Order o;
	Worker w;
	MySystem ms;
	Admin a;
	String id,s;
	public void WorkerAvailable(Order o,Worker w,MySystem ms,Admin a) {
		this.o=o;
		this.a=a;
		this.w=w;
		this.ms=ms;
	}
	@Given("that these worker are registered in the system")
	public void that_these_worker_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String id,name,phone,address;
		boolean isFree;
		for(int i=0; i<4;i++) {
			id=dataTable.cell(i, 0);
			name=dataTable.cell(i,1);
			phone=dataTable.cell(i,2);
			address=dataTable.cell(i, 3);
			isFree=Boolean.valueOf(dataTable.cell(i,4));
			
			w=new Worker(id,name,phone,address,isFree);
			ms.Workers.add(w);   
			}
	    throw new io.cucumber.java.PendingException();
	}

	@Given("that there is order with id {string}")
	public void that_there_is_order_with_id(String string) {
	    id=string;
	}

	@When("admin tries to distribute the order to the worker")
	public void admin_tries_to_distribute_the_order_to_the_worker() {
	    s=a.distribute(ms,w,o);
	}

	@When("the worker is free")
	public void the_worker_is_free() {
	   w.setIsFree(true);
	}

	@Then("msg {string} display")
	public void msg_display(String string) {
	    assertEquals(s,string);
	}

	@Then("the status change to intreatment")
	public void the_status_change_to_intreatment() {
	    assertEquals(o.getStatus(),Status.INTREATMENT);

	
	
	
	
	
	
	}
	
	
}
