import java.lang.Cloneable;

abstract class Person {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public abstract String getDescription();
	
	public String getName() {
		return name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}