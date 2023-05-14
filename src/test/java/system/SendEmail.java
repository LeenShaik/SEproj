package system;


import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendEmail {
 
	Order o ;
	MySystem ms=new MySystem();
	String email;
	boolean check;
	

	@Given("the order status is complete")
	public void the_order_status_is_complete() {
	}

	@When("admin tries to send email to customer whose email is {string}")
	public void admin_tries_to_send_email_to_customer_whose_email_is(String string) {
	    email=string;
	    check=ms.sendEmail(email);
	}

	@Then("email sent successfully")
	public void email_sent_successfully() {
	   assertTrue(check);
	}
}
