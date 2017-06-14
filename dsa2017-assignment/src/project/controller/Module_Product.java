package project.controller;

import java.io.File;

import project.entity.Product;
import project.my_list.MyList;
import project.my_list.MyNode;

public class Module_Product {
	// List<Product> products;
	MyList<Product> products;
	File file;

	public Module_Product() {
		file = Read_write_file.getDesktopFile("dsa2017-data/1e2/products.json");
		products = new MyList<>();
	}

	public MyList<Product> readData() {
		try {
			products = Read_write_file.readFileJson(file, Product.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public void writeData(MyList<Product> products) {
		try {
			Read_write_file.writeFileJson(file, products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MyNode<Product> searchByCode(String code) {
		MyNode<Product> c = null;
		try {
			for (Product product : products) {
				if (product.pcode.equals(code)) {
					c = new MyNode<Product>(product);
					c.t.setPcode(product.getPcode());
					c.t.setPro_name(product.getPro_name());
					c.t.setQuantity(product.getQuantity());
					c.t.setSale(product.getSale());
					c.t.setPrice(product.getPrice());
					// c.t.setPro_image_url(product.t.getPro_name());
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
			for (Product product : products) {
				if (product.pcode.equals(code)) {
					products.remove(product);
					check = true;
				}
			}
			writeData(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public MyList<Product> sortByPcode(MyList<Product> myList) {
		for (int i = 0; i < myList.size(); i++) {
			for (int j = i + 1; j < myList.size(); j++) {
				if (myList.get(j).t.pcode.compareTo(myList.get(i).t.pcode) < 0) {
					Product temp = myList.get(j).t;
					myList.get(j).t = myList.get(i).t;
					myList.get(i).t = temp;
				}
			}
		}
		return myList;
	}

	public boolean deleleAfterCode(String code) {
		boolean check = false;
		try {
			for (Product product : products) {
				if (product.pcode.equals(code)) {
					products.removeAfter(product);
					check = true;
				}
			}
			writeData(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
