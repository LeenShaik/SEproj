package system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Login {
	public Admin a;
	String username,pass;
	
	public Login(Admin a) {
		this.a=a;
	}



@Given("admin is not logged in")
public void admin_is_not_logged_in() {
	a.setLoginState(false);
}

@Given("the username is {string}")
public void the_username_is(String string) {
    username=string;
}

@Given("the password is {string}")
public void the_password_is(String string) {
    pass=string;
}

@Then("the admin login succeeds")
public void the_admin_login_succeeds() {
    assertTrue(a.login(username,pass));
    a.setLoginState(true);
}

@Then("the admin is logged in")
public void the_admin_is_logged_in() {
   assertTrue(a.getLoginState());
}

@Then("the admin login fails")
public void the_admin_login_fails() {
	assertFalse(a.login(username,pass));
	a.setLoginState(false);
}

@Then("the admin is not logged in")
public void the_admin_is_not_logged_in() {
	assertFalse(a.getLoginState());
}

}
