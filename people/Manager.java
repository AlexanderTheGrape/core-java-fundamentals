

sealed class Manager extends Employee
		permits Executive {
	
	private int bonus;
	
	public Manager(String name, int salary, int bonus) {
		super(name, salary);
		this.bonus = bonus;
	}
	
	public int getSalary() {
		return super.getSalary() + this.getBonus();
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public static void main(String[] args) {
		Employee employee = new Employee("Kowabunga", 50000);
		Manager bigMan = new Manager("hello", 40000, 10000);
		System.out.println(bigMan.compareTo(employee));
	}
	
}