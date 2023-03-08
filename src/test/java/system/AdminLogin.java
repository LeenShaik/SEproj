package system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminLogin {
	public Admin a;
	public MySystem s;
	String username,pass;
	
	public AdminLogin(MySystem s) {
		this.s=s;
	}

@Given("that this is admin table")
public void that_this_is_admin_table(io.cucumber.datatable.DataTable dataTable) {
	String name ,pass,email,phone;
	for(int i=0; i<2;i++) {
		   name=dataTable.cell(i,0);
		   pass=dataTable.cell(i,1);
		   email=dataTable.cell(i,2);
		   phone=dataTable.cell(i,3);
		   
		   a=new Admin(name,pass,email,phone);
		   s.Admins.add(a);   
		   }
    throw new io.cucumber.java.PendingException();
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
}

@Then("the admin is logged in")
public void the_admin_is_logged_in() {
   assertTrue(a.getLoginState());
}

@Then("the admin login fails")
public void the_admin_login_fails() {
	assertFalse(a.login(username,pass));
}

@Then("the admin is not logged in")
public void the_admin_is_not_logged_in() {
	assertFalse(a.getLoginState());
}

}
