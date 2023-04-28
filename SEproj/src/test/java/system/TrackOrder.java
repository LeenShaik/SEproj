package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TrackOrder {
Order o;
Status s;
public void TrackOrder(Order o) {
	this.o=o;
	
}
@Given("that order status is waiting")
public void that_order_status_is_waiting() {
    o.setStatus(Status.WAITING);
}

@Given("admin want to set status to in treatment")
public void admin_want_to_set_status_to_in_treatment() {
   s=Status.INTREATMENT;
}

@Then("order status is in treatment")
public void order_status_is_in_treatment() {
    assertEquals(s,o.getStatus());
}

@Given("that order status is in treatment")
public void that_order_status_is_in_treatment() {
    o.setStatus(Status.INTREATMENT);
}

@Given("admin want to set statue to complete")
public void admin_want_to_set_statue_to_complete() {
    s=Status.COMPLETE;
}

@Then("order status is complete")
public void order_status_is_complete() {
    assertEquals(s,o.getStatus());
}









}
