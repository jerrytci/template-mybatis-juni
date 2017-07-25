package remix.chen.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Order {
	private int id;
	private String name;
	private String description;
	//订单金额
	private int totalPrice;
	private List<Good> goods;
	
	public Order(int id, String name, String description, int totalPrice, List<Good> goods) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.totalPrice = totalPrice;
		this.goods = goods;
	}

	public Order() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", description=" + description + ", totalPrice=" + totalPrice
				+ ", goods=" + goods + "]";
	}
}
