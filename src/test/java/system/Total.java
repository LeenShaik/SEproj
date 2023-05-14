package system;



import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Total {
	
	MySystem system=new MySystem();
	
	int cash,paid,delivered;
	
	

	@Given("that these orders are in the system")
	public void that_these_orders_are_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		Order order=new Order("1","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("2","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("3","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("4","id1","2","445",1,20,30);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("5","id1","0","445",1,20,13);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("6","id1","5","123",1,12,8);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("7","id2","4","113",1,12,20);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("8","987654","4","113",1,0,20);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
	}


	@When("admin tries to show the total cash")
	public void admin_tries_to_show_the_total_cash() {
	   cash = system.totalCash();
	}
	@Then("total cash = {int} printed")
	public void total_cash_printed(int int1) {
	    assertEquals(cash,int1);
	}
	@When("admin tries to show the total paid")
	public void admin_tries_to_show_the_total_paid() {
	    paid=system.totalPaid();

	}
	@Then("total paid = {int} printed")
	public void total_paid_printed(int int1) {
		 assertEquals(paid,int1);
	}
	

	@When("admin tries to show the delivered items")
	public void admin_tries_to_show_the_delivered_items() {
	    delivered=system.totaldelivery();
	}
	@Then("total delivered items = {int} printed")
	public void total_delivered_items_printed(int int1) {
		assertEquals(delivered,int1);
	}
	

	

	
	
}
