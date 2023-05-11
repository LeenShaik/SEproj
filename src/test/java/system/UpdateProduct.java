package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProduct {
	public Admin a;
	public Product p;
	public MySystem ms;
	String s,ID,whatUpdate,newValue;
	boolean valid;
	boolean updated;
	public UpdateProduct(Admin a,MySystem ms) {
		this.a=a;
		this.ms=ms;
	}
	
	
	
	
	

@Given("that these products are valid in the system")
public void that_these_products_are_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	String name,id ;
	int price;
	for(int i=0; i<6;i++) {
		id=dataTable.cell(i, 0);
		name=dataTable.cell(i,1);
		price=Integer.parseInt(dataTable.cell(i,2));
		p=new Product(id,name,price);
		ms.products.add(p);   
		}
    throw new io.cucumber.java.PendingException();
}

@Given("that the admin is logged in")
public void that_the_admin_is_logged_in() {
	 a.setLoginState(true);
}

@Given("he want to update product that its id {string}")
public void he_want_to_update_product_that_its_id(String string) {
	ID=string;
}


@When("admin tries to update a product {string} to {string}")
public void admin_tries_to_update_a_product_to(String string, String string2) {
	    whatUpdate=string;
		newValue=string2; 
		s=ms.updateProduct(whatUpdate,ID,newValue);
}

@Then("massage {string} should display")
public void an_information_massage_should_display(String string) {
	assertEquals(string,s);
}


}
