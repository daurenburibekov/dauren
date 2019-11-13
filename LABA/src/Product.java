
public class Product implements Comparable<Product>{
	
	private int id;
	private String name;
	private int quantity;
	private int price;
	//private int quantityLeft;
	public Product(int id, String name, int quantity, int price) {
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	/*public int getQuantityLeft() {
		return quantityLeft;
	}
	public void setQuantityLeft(int quantityLeft) {
		this.quantityLeft = quantityLeft;
	}*/

	@Override
	public String toString() {
		return "Product name=" + name + ", quantity=" + quantity + ", price=" + price;
	}
	@Override
	public int compareTo(Product o) {
		return this.price-o.price;
	}

}
