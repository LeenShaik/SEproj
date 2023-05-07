package system;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Report {
	MySystem system;
	Customer c;
	Product p;
	Worker w;
	boolean b;
	public void report(MySystem system,Customer c,Product p,Worker w) {
		this.system=system;
	}
	

	@Given("that these customers are registered in the system")
	public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String id,name,email,phone,address;
		int numOfReq;
		for(int i=0; i<3;i++) {
			id=dataTable.cell(i, 0);
			name=dataTable.cell(i,1);
			email=dataTable.cell(i,2);
			numOfReq=Integer.parseInt(dataTable.cell(i, 3));
			phone=dataTable.cell(i,4);
			address=dataTable.cell(i,5);
			c=new Customer(id,name,email,numOfReq,phone,address);
			system.Customers.add(c);   
			}
	    throw new io.cucumber.java.PendingException();
	}

	@Given("these products are valid in the system")
	public void these_products_are_valid_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String name,id ;
		int price;
		for(int i=0; i<6;i++) {
			id=dataTable.cell(i, 0);
			name=dataTable.cell(i,1);
			price=Integer.parseInt(dataTable.cell(i,2));
			p=new Product(id,name,price);
			system.Products.add(p);   
			}
	    throw new io.cucumber.java.PendingException();
	}

	@Given("that these worker are registered in the system")
	public void that_these_worker_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		String id,name,phone,address;
		boolean isFree;
		for(int i=0; i<4;i++) {
			id=dataTable.cell(i, 0);
			name=dataTable.cell(i,1);
			phone=dataTable.cell(i,2);
			address=dataTable.cell(i, 3);
			isFree=Boolean.valueOf(dataTable.cell(i,4));
			
			w=new Worker(id,name,phone,address,isFree);
			system.Workers.add(w);   
			}
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin tries to show the report")
	public void admin_tries_to_show_the_report() {
	    b= system.Report();
	}

	@Then("report will display")
	public void report_will_display() {
	    assertTrue(b);
	}
}
