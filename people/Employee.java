
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
	}
	
}

