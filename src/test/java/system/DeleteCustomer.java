package system;

import io.cucumber.java.en.Given;

public class DeleteCustomer {
	public Admin a;
	public Customer c;
	public MySystem ms;
	String s,ID,whatUpdate,newValue;
	boolean updated;
	public DeleteCustomer(Admin a,MySystem ms) {
		this.a=a;
		this.ms=ms;
	}

@Given("that these customers are registered in the system")
public void that_these_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	String id,name ,pass,email,phone,address;
	int numOfReq;
	for(int i=0; i<3;i++) {
		id=dataTable.cell(i, 0);
		name=dataTable.cell(i,1);
		pass=dataTable.cell(i,2);
		email=dataTable.cell(i,3);
		numOfReq=Integer.parseInt(dataTable.cell(i, 4));
		phone=dataTable.cell(i,5);
		address=dataTable.cell(i,6);
		c=new Customer(id,name,pass,email,numOfReq,phone,address);
		ms.Customers.add(c);   
		}
    throw new io.cucumber.java.PendingException();
}

	
	
	
}
