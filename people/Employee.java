import java.lang.NullPointerException;
import java.lang.ClassCastException;


class Employee extends Person implements Cloneable, Comparable {
	
	private int salary;
	
	public Employee(String name, int salary) {
		super(name);
		this.salary = salary;
	}
	
	public String getDescription() {
		return "An employee called " + this.getName() + "with a salary of " + salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int compareTo(Object other) throws ClassCastException, NullPointerException {
		if (other == null) throw new NullPointerException();
		if (other.getClass().isInstance(Employee.class)) {
			return (this.getSalary() > ((Employee)other).getSalary()) ? 1 : -1;
		} else throw new ClassCastException();
	}

	public static void main(String[] args) {
		Employee someDude = new Employee("Kowabunga", 50000);
		System.out.println(someDude.getName());
		System.out.println(someDude.getDescription());
		
		// Reflection
		Class cl = someDude.getClass();
		System.out.println(someDude.getClass().getName());
		Object secondDude = null;
		try {
			Class unknownClassType = Class.forName("java.lang.Math");
			System.out.println(unknownClassType);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			secondDude = someDude.clone(); // TODO FIX - FAILS DUE TO NOT IMPLEMENTING THE CLONEABLE INTERFACE. SEE OBJECT
			//secondDude = (Employee)someDude.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		
		if (secondDude != null) {
			assert(secondDude == someDude);
			System.out.println(secondDude == someDude);
		}
		System.out.println(secondDude == someDude);
		//System.out.println(some.getSalary() + " dollars earned by " + someDude.getName());
		
		System.out.println("Comparing with compareTo():");
		System.out.println(someDude.compareTo(secondDude));
	}
	
}

