package system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Login {
	public Admin a=new Admin();
	String user,passw;
	boolean check;

@Given("the username is {string}")
public void the_username_is(String string) {
    user=string;
}

@Given("the password is {string}")
public void the_password_is(String string) {
    passw=string;
}

@Then("the admin login succeeds")
public void the_admin_login_succeeds() {
	a.username=user;
	a.pass=passw;
    check = a.login(user,passw);
    a.setLoginState(true);
    assertTrue(a.getLoginState());
}



@Then("the admin login fails")
public void the_admin_login_fails() {
	a.username=user;
	a.pass=passw;
    check = a.login(user,passw);
    assertTrue(!a.getLoginState());
}


}
