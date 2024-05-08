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
		//System.out.println("class of other is: " + other.getClass().toString());
		//System.out.println(" is it an instance? " + Employee.class.isInstance(other));
		//System.out.println(" salary 1 is: " + this.getSalary());
		//System.out.println(" salary 1 is: " + ((Employee)other).getSalary());
		
		if (other == null) throw new NullPointerException();
		//if (Employee.class.isInstance(other)) {	
		if (other instanceof Employee) {	
			if (this.getSalary() > ((Employee)other).getSalary()) {
				return 1;
			} else if (this.getSalary() < ((Employee)other).getSalary()) {
				return -1;
			} else {
				return 0;
			}
		} else throw new ClassCastException();
	}

	public static void main(String[] args) {
		Employee someDude = new Employee("Kowabunga", 50000);
		Employee employee = new Employee("Kowabunga", 50001);
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
		System.out.println(someDude.compareTo(employee));
		System.out.println(employee.compareTo(employee));
		System.out.println(employee.compareTo(someDude));
	}
}

