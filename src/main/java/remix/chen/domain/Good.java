package remix.chen.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Good {
	private int id;
	private String name;
	private int price;
	//商品存货数量
	private int stock;
	private List<Order> orders;
	
	public Good(int id, String name, int price, int stock, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.orders = orders;
	}
	public Good() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", orders=" + orders
				+ "]";
	}
}
