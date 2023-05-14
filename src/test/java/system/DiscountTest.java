package system;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DiscountTest {
	Customer c = new Customer ("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia");
	MySystem ms;
	Product p;
	
	
	@Given("that the count of request for customer is {int}")
	public void that_the_count_of_request_for_customer_is(Integer int1) {
	   c.numOfReq=int1;
	}

	

	@Then("discount will apply")
	public void discount_will_apply() {
	   assertTrue( c.hasDiscount());
	}

	@Then("The discount does not apply")
	public void the_discount_does_not_apply() {
	    assertFalse(c.hasDiscount());
	}
}
