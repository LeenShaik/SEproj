package system;



import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Total {
	
	MySystem ms;
	Order o;
	int cash,paid,delivered;
	public void Total(MySystem ms,Order o) {
		this.ms=ms;
		this.o=o;
	}
	

	@Given("that these orders are in the system")
	public void that_these_orders_are_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String oid,cid,pid,wid; int n,delivery,price;
		Status status;
		
		for(int i=0; i<8;i++) {
			oid=dataTable.cell(i, 0);
			cid=dataTable.cell(i,1);
			pid=dataTable.cell(i,2);
			wid=dataTable.cell(i, 3);
			n=Integer.parseInt(dataTable.cell(i,4));
			delivery=Integer.parseInt(dataTable.cell(i,5));
			price=Integer.parseInt(dataTable.cell(i,6));
			status=Status.valueOf(dataTable.cell(i, 7));

			o=new Order(oid,cid,pid,wid,n,delivery,price,status);
			ms.Orders.add(o);   
			}
	    throw new io.cucumber.java.PendingException();
	}


	@When("admin tries to show the total cash")
	public void admin_tries_to_show_the_total_cash() {
	   cash = ms.totalCash();
	}
	@Then("total cash = {int} printed")
	public void total_cash_printed(int int1) {
	    assertEquals(cash,int1);
	}
	@When("admin tries to show the total paid")
	public void admin_tries_to_show_the_total_paid() {
	    paid=ms.totalPaid();
	}
	@Then("total paid = {int} printed")
	public void total_paid_printed(int int1) {
		 assertEquals(paid,int1);
	}
	

	@When("admin tries to show the delivered items")
	public void admin_tries_to_show_the_delivered_items() {
	    delivered=ms.totaldelivery();
	}
	@Then("total delivered items = {int} printed")
	public void total_delivered_items_printed(int int1) {
		assertEquals(delivered,int1);
	}
	

	

	
	
}
