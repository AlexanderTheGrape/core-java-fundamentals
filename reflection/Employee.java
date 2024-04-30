//import lombok.EqualsAndHashCode;
package reflection;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
class Employee extends Person {
	
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

	public static void main(String[] args) {
		Employee someDude = new Employee("Kowabunga", 50000);
		System.out.println(someDude.getName());
		System.out.println(someDude.getDescription());
		
		// Reflection
		Class cl = someDude.getClass();
		System.out.println(someDude.getClass().getName());
		Object secondDude = null;
		Employee thirdDude = null;
		try {
			Class unknownClassType = Class.forName("java.lang.Math");
			System.out.println(unknownClassType);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			secondDude = someDude.clone();
			thirdDude = (Employee)someDude.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		
		if (secondDude != null && thirdDude != null) {
			System.out.println("Is secondDude (cloned employee) equal to someDude, using ==? " + (secondDude == someDude));
			System.out.println("Is secondDude equal to someDude, using .equals()? " + secondDude.equals(someDude));
			System.out.println("Is thirdDude (cloned employee, casted as employee) equal to someDude, using .equals()? " + thirdDude.equals(someDude));
			System.out.println("thirdDude canonical class name is: " + thirdDude.getClass().getCanonicalName());
		}
		//System.out.println(some.getSalary() + " dollars earned by " + someDude.getName());
		
		
	}
	
}

