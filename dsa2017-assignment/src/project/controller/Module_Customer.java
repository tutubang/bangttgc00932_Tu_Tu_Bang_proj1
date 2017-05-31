package project.controller;

import java.io.File;
import project.entity.Customer;
import project.my_list.MyList;
import project.my_list.MyNode;

public class Module_Customer {
	MyList<Customer> customers;
	File file;
	
	public Module_Customer() {
		file = Read_write_file.getDesktopFile("dsa2017-data/1e5/customers.json");
		customers = new MyList<>();
	}

	public MyList<Customer> readData() {
		try {
			customers = Read_write_file.readFileJson(file, Customer.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	public void writeData(MyList<Customer> customers) {
		try {
			Read_write_file.writeFileJson(file, customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MyNode<Customer> searchByCode(String code) {
		MyNode<Customer> c = null;
		try {
			for (Customer customer : customers) {
				if (customer.ccode.equals(code)) {
					c = new MyNode<Customer>(customer);
					c.t.setCcode(customer.getCcode());
					c.t.setCus_name(customer.getCus_name());
					c.t.setPhone(customer.getPhone());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public boolean deleteByCode(String code) {
		boolean check = false;
		try {
			for (Customer customer : customers) {
				if (customer.ccode.equals(code)) {
					customers.remove(customer);
					check = true;
				}
			}
			writeData(customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
