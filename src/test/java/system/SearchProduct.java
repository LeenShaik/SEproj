package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	public MySystem system=new MySystem();
	boolean check;
	String id ;


@Given("that this products are valid in the system")
public void that_this_products_are_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	system.products.add(new Product("0","CARPET minimum than 9",15));
	system.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
	system.products.add(new Product("2","CARPET greater than 16",30));
	system.products.add(new Product("3","SINGLECOVER",13));
	system.products.add(new Product("4","COUPLECOVER",20));
	system.products.add(new Product("5","CURTAIN",8));
}



@When("admin tries to search for id {string}")
public void admin_tries_to_search_for_id(String string) {
    id=string;
    system.searchProduct(id);
    check=system.productValid(id);
    
}

@Then("search success")
public void search_success() {
	assertTrue(check);
}
@Then("search faild")
public void search_faild() {
	assertTrue(!check);

}




}
