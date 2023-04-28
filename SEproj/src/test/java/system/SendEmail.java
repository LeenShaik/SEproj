package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendEmail {
 
	Order o ;
	Admin a;
	String email,msg;
	public void SendEmail(Admin a,Order o) {
		this.a=a;
		this.o=o;
	}
	
	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
	    a.setLoginState(true);
	}

	@Given("the order status is complete")
	public void the_order_status_is_complete() {
	    o.status=Status.COMPLETE;
	}

	@When("admin tries to send email to customer whose email is {string}")
	public void admin_tries_to_send_email_to_customer_whose_email_is(String string) {
	    email=string;
	}

	@Then("this massage : {string} will appear")
	public void this_massage_will_appear(String string) {
	   msg= a.sendEmail(email);
	   assertEquals(msg,string);
	}
}
