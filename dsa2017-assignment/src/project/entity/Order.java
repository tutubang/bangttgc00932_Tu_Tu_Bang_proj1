package project.entity;

public class Order {
	public String pcode;
	public String ccode;
	public Integer quantity;
	
	public Order(String pcode, String ccode, Integer quantity) {
		this.pcode = pcode;
		this.ccode = ccode;
		this.quantity = quantity;
	}

	
	public Order() {
	}


	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
