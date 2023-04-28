package system;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	public Admin a;
	public MySystem ms;
	public Product p;
	String s,id ;
	public SearchProduct(Admin a,MySystem ms,Product p) {
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
    throw new io.cucumber.java.PendingException();
}

@Given("that the admin is logged in")
public void that_the_admin_is_logged_in() {
    a.setLoginState(true);
} 

@When("admin tries to search for id {string}")
public void admin_tries_to_search_for_id(String string) {
    id=string;
    s=a.searchProduct(id,ms);
    
}

@Then("this msg {string} should display")
public void this_msg_should_display(String string) {
	assertEquals(string,s);
}




}
