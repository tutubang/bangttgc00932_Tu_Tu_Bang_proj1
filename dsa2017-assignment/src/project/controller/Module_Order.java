package project.controller;

import java.io.File;

import project.entity.Order;
import project.my_list.MyList;

public class Module_Order {
	MyList<Order> orders;
	File file;
	public  Module_Order() {
		file = Read_write_file.getDesktopFile("dsa2017-data/1e2/orders.json");
		orders = new MyList<>();
	}

	public MyList<Order> readData() {
		try {
			orders = Read_write_file.readFileJson(file, Order.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public MyList<Order> sortByCcode(MyList<Order> myList) {
		for (int i = 0; i < myList.size(); i++) {
			for (int j = i + 1; j < myList.size(); j++) {
				if (myList.get(j).t.ccode.compareTo(myList.get(i).t.ccode) < 0) {
					Order temp = myList.get(j).t;
					myList.get(j).t = myList.get(i).t;
					myList.get(i).t = temp;
				}
			}
		}
		return myList;
	}
	
	public MyList<Order> sortByPcode(MyList<Order> myList) {
		for (int i = 0; i < myList.size(); i++) {
			for (int j = i + 1; j < myList.size(); j++) {
				if (myList.get(j).t.pcode.compareTo(myList.get(i).t.pcode) < 0) {
					Order temp = myList.get(j).t;
					myList.get(j).t = myList.get(i).t;
					myList.get(i).t = temp;
				}
			}
		}
		return myList;
	}
}
