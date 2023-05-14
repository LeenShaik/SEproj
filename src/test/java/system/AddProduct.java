package system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProduct {
	public MySystem system=new MySystem();
	Product p;
	boolean check;

@Given("these productss are valid in the system")
public void that_these_productss_are_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	system.products.add(new Product("0","CARPET minimum than 9",15));
	system.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
	system.products.add(new Product("2","CARPET greater than 16",30));
	system.products.add(new Product("3","SINGLECOVER",13));
	system.products.add(new Product("4","COUPLECOVER",20));
	system.products.add(new Product("5","CURTAIN",8));
}



@Given("there is a product with id {string},name {string},price {int}")
public void there_is_a_product_with_id_name_price(String string, String string1, int int1) {
    p=new Product(string1,string1,int1);
}

@When("admin tries to add product")
public void admin_tries_to_add_product() {
	check = system.addProduct(p);
}

@Then("add product faild")
public void add_product_faild() {
	assertTrue(check);
	

}
@Then("add product success")
public void add_product_success() {
	assertTrue(check);
	

}







}
