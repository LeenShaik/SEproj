package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProduct {
	public MySystem system=new MySystem();
	String id;
	int after,before;
	

	

@Given("these products valid in the system")
public void these_products_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	system.products.add(new Product("0","CARPET minimum than 9",15));
	system.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
	system.products.add(new Product("2","CARPET greater than 16",30));
	system.products.add(new Product("3","SINGLECOVER",13));
	system.products.add(new Product("4","COUPLECOVER",20));
	system.products.add(new Product("5","CURTAIN",8));
}



@Given("that admin want to delete product that its id {string}")
public void that_admin_want_to_delete_product_that_its_id(String string) {
	before=system.products.size();
    id=string;
}

@When("admin tries to delete a product")
public void admin_tries_to_delete_a_product() {
	system.deleteProduct(id);
	after=system.products.size();

}

@Then("product deleted faild")
public void product_deleted_faild() {
	assertEquals(before,after);
	
}
@Then("product deleted successfully")
public void product_deleted_successfully() {
	assertEquals(before-1,after);
	
}

}
