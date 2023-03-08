package system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Invoice {
	public Customer c;
	public Product p;
	public InvoiceCalc i;
	int total;
	int numOfProduct=1;
	productName pName;
    int productSpace = 4 ;

@Given("that the customer are registered in the system")
public void that_the_customer_are_registered_in_the_system() {
   c.isregistered(c);
}

@Given("the customer logged in successfully")
public void the_customer_logged_in_successfully() {
    c.setLoginState(true);
}

@Given("he want to clean {string} , productSpace {int}")
public void he_want_to_clean_product_space(String string, Integer int1) {
	pName=productName.valueOf(string);
    productSpace=int1;

}
@Given("has discount")
public void has_discount() {
	/////////////////////////////////////////////// ????????????? add name or id in invoice.feature to know if has discount or not !
    
}
@Then("the price is {int}")
public void the_price_is(Integer int1) {
 total = i.total(pName,productSpace,numOfProduct);
}

@Given("he want to clean {string}")
public void he_want_to_clean(String string) {
	pName=productName.valueOf(string);
    
}
@Given("he want to clean  {int} {string}")
public void he_want_to_clean(Integer int1, String string) {
	numOfProduct=int1;
	pName=productName.valueOf(string);
}
}
