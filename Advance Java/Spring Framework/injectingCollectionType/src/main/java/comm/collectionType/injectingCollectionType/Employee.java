package comm.collectionType.injectingCollectionType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
	private String name;
	private List<String> phones;

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	private Map<String, String> courses;


	public Employee(String name, List<String> phones, Map<String, String> courses) {
		super();
		this.name = name;
		this.phones = phones;
		this.courses = courses;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
