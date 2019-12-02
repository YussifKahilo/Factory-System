package FactorySystem;


public class Person {
	private String id;
	private String name;
	private String password;
	public Person() {
		
	}
	public Person(String id,String name ,String password) {
		this.id = id;
                this.name = name;
                this.password = password;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}