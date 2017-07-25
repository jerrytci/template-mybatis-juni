package remix.chen.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person {
	private int id;
	private String name;
	private List<Mobile> mobiles;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id) {
		super();
		this.id = id;
	}
	public Person(int id, String name, List<Mobile> mobiles) {
		super();
		this.id = id;
		this.name = name;
		this.mobiles = mobiles;
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public List<Mobile> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<Mobile> mobiles) {
		this.mobiles = mobiles;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobiles=" + mobiles + "]";
	}

}
