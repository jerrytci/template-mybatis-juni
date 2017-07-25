package remix.chen.domain;

import org.springframework.stereotype.Component;

@Component
public class TestLock {
	private int id;
	private int version=0;
	private String description;
	public TestLock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestLock(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public TestLock(int id, int version, String description) {
		super();
		this.id = id;
		this.version = version;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TestLock [id=" + id + ", version=" + version + ", description=" + description + "]";
	}

}
