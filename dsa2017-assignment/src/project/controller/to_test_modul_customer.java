package project.controller;

import project.entity.Customer;
import project.my_list.MyList;
import project.my_list.MyNode;

public class to_test_modul_customer {
	public static void main(String[] args) {
		Module_Customer module_Customer = new Module_Customer();
		// 1.1 Load data from file
		MyList<Customer> myList = module_Customer.readData();
		// 1.2 input and add new item
		Customer customer = new Customer("CST123456", "Tu Tu Bang", "01667909317");
		// 1.3 Display data
		System.out.println("------------- Display data---------------");
		for (Customer customer1 : myList) {
			System.out.println(customer1.ccode + "|" + customer1.cus_name + "|" + customer1.phone);
		}
		// 1.4 Save product list to file
		myList.add(customer);
		module_Customer.writeData(myList);
		// 1.5 Search by ccode
		System.out.println("------------- Search by ccode---------------");
		MyNode<Customer> myNode = module_Customer.searchByCode("CST123456");
		if (myNode != null) {
			System.out.println(myNode.t.ccode + "|" + myNode.t.cus_name + "|" + myNode.t.phone);
		} else {
			System.out.println("No find anyone!");
		}
		// 1.6 Delete by ccode
		System.out.println("------------- Delete by ccode---------------");
		if (module_Customer.deleteByCode("CST123456")) {
			System.out.println("Delete success!");
		} else {
			System.out.println("Delete fail!");
		}		
	}
}
