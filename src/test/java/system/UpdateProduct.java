package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProduct {
	public Admin a=new Admin();
	public MySystem ms=new MySystem();
	String ID,whatUpdate,newValue;
	boolean valid;
	boolean updated;
	boolean check;
	

@Given("that these products are valid in the system")
public void that_these_products_are_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {

	ms.products.add(new Product("0","CARPET minimum than 9",15));
	ms.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
	ms.products.add(new Product("2","CARPET greater than 16",30));
	ms.products.add(new Product("3","SINGLECOVER",13));
	ms.products.add(new Product("4","COUPLECOVER",20));
	ms.products.add(new Product("5","CURTAIN",8));
}




@Given("he want to update product that its id {string}")
public void he_want_to_update_product_that_its_id(String string) {
	ID=string;
}


@When("admin tries to update a product {string} to {string}")
public void admin_tries_to_update_a_product_to(String string, String string2) {
	    whatUpdate=string;
		newValue=string2; 
		ms.updateProduct(whatUpdate,ID,newValue);
		check=ms.pisupdated(ID);
}

@Then("update success")
public void  update_success() {
		assertTrue(check);
}
@Then("update faild")
public void  update_faild() {
	
	assertTrue(!check);
}


}
