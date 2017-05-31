package project.controller;

import project.entity.Product;
import project.my_list.MyList;
import project.my_list.MyNode;

public class to_test_modul_product {
	public static void main(String[] args) {
		Module_Product module_Product = new Module_Product();
		// 1.1 Load data from file
		MyList<Product> myList = module_Product.readData();
		// 1.2 input and add new item
		Product Product = new Product("PRD123456", "Durex", 100, 50, 10000, "");
		// 1.3 Display data
		System.out.println("------------- Display data---------------");
		for (Product product1 : myList) {
			System.out.println(product1.pcode + "|" + product1.pro_name + "|" + product1.quantity + "|" + product1.sale
					+ "|" + product1.price);
		}
		// 1.4 Save product list to file
		myList.add(Product);
		module_Product.writeData(myList);
		// 1.5 Search by pcode
		System.out.println("------------- Search by ccode---------------");
		MyNode<Product> myNode = module_Product.searchByCode("PRD123456");
		if (myNode != null) {
			System.out.println(myNode.t.pcode + "|" + myNode.t.pro_name + "|" + myNode.t.quantity + "|" + myNode.t.sale
					+ "|" + myNode.t.price);
		} else {
			System.out.println("No find anyone!");
		}
		// 1.6 Delete by pcode
		System.out.println("------------- Delete by ccode---------------");
		if (module_Product.deleteByCode("PRD123456")) {
			System.out.println("Delete success!");
		} else {
			System.out.println("Delete fail!");
		}
		// 1.7 Sort by pcode
		module_Product.sortByPcode(myList);
		for (Product product2 : myList) {
			System.out.println(product2.pcode + "|" + product2.pro_name + "|" + product2.quantity + "|" + product2.sale
					+ "|" + product2.price);
		}
		// 1.8 Delete the node after the node having code = xCode
	}
}
