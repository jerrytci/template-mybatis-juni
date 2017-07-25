package remix.chen.domain;

import org.springframework.stereotype.Component;

@Component
public class Mobile {
	private int id;
	private int no;
	private String phone;
	private Person person;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(int id, int no, String phone, Person person) {
		super();
		this.id = id;
		this.no = no;
		this.phone = phone;
		this.person = person;
	}

	public Mobile(int id, int no, String phone) {
		super();
		this.id = id;
		this.no = no;
		this.phone = phone;
	}
	public Mobile(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
			
	@Override
	public String toString() {
//		return "Mobile [id=" + id + ", no=" + no + ", phone=" + phone + "]";
		return "Mobile [id=" + id + ", no=" + no + ", phone=" + phone + ", person=" + person + "]";
	}
}


