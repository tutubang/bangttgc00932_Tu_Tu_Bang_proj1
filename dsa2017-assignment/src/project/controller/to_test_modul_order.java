package project.controller;

import project.entity.Order;
import project.my_list.MyList;

public class to_test_modul_order {
	public static void main(String[] args) {
		Module_Order module_Order = new Module_Order();
		//3.1. Input data
		MyList<Order> myList = module_Order.readData();
		//3.2. Display data with total value
		System.out.println("------------- Display data with total value---------------");
		int count = 0;
		for (Order order : myList) {
			System.out.println(order.pcode + "|" + order.ccode + "|" + order.quantity);
			count++;
		}
		System.out.println("Data has: " + count + "value!");
		//3.3. Sort  by pcode
		module_Order.sortByPcode(myList);
		for (Order order : myList) {
			System.out.println(order.pcode + "|" + order.ccode + "|" + order.quantity);
		}
		//3.3 Sort by ccode
		module_Order.sortByCcode(myList);
		for (Order order : myList) {
			System.out.println(order.pcode + "|" + order.ccode + "|" + order.quantity);
		}
	}
}
