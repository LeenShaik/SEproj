package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TrackOrder {
Order o = new Order("8","987654","4","113",1,0,20);
Status s,k;
Admin a = new Admin();



@Given("admin want to set status to in treatment")
public void admin_want_to_set_status_to_in_treatment() {
  s= a.setStatus(o, Status.INTREATMENT);
}

@Then("order status is in treatment")
public void order_status_is_in_treatment() {
    assertEquals(s,o.getStatus());
}



@Given("admin want to set statue to complete")
public void admin_want_to_set_statue_to_complete() {
    k=a.setStatus(o,Status.COMPLETE);
}

@Then("order status is complete")
public void order_status_is_complete() {
    assertEquals(k,o.getStatus());
}









}
