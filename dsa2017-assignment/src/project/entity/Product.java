package project.entity;

public class Product {
	public String pcode;
	public String pro_name;
	public int quantity ;
	public int sale;
	public double price;
	public String pro_image_url;
	
	
	@Override
	public String toString() {
		return "Product [pcode=" + pcode + ", pro_name=" + pro_name + ", quantity=" + quantity + ", sale=" + sale
				+ ", price=" + price + ", pro_image_url=" + pro_image_url + "]";
	}
	public Product() {
		super();
	}
	public Product(String pcode, String pro_name, int quantity, int sale, double price, String pro_image_url) {
		super();
		this.pcode = pcode;
		this.pro_name = pro_name;
		this.quantity = quantity;
		this.sale = sale;
		this.price = price;
		this.pro_image_url = pro_image_url;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPro_image_url() {
		return pro_image_url;
	}
	public void setPro_image_url(String pro_image_url) {
		this.pro_image_url = pro_image_url;
	}
	
	
}
