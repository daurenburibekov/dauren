
public class Order {
	private String productName;
	private int price;
	 
	public Order (String productName, int price) {
		this.productName=productName;
		this.price=price;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return productName;
	}
	public void setName(String name) {
		this.productName = name;
	}
	@Override
	public String toString() {
		return "Order [productName=" + productName + ", price=" + price + "]";
	}

}
