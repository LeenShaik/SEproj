package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProduct {
	public Admin a;
	public MySystem ms;
	public Product p;
	String s,id;
	int after,before;
	
	public DeleteProduct(Admin a,MySystem ms ,Product p) {
		this.a=a;
		this.ms=ms;
		this.p=p;
		
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
		ms.Products.add(p);   
		}
	before=ms.Products.size();
    throw new io.cucumber.java.PendingException();
}



@Given("that admin want to delete product that its id {string}")
public void that_admin_want_to_delete_product_that_its_id(String string) {
    id=string;
}

@When("admin tries to delete a product")
public void admin_tries_to_delete_a_product() {
	s=ms.deleteProduct(id);
	after=ms.Products.size();

}

@Then("a massage {string} should display")
public void a_massage_should_display(String string) {
	assertEquals(string,s);
	assertEquals(after,before-1);
	
}

}
