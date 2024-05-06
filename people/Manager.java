

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
	
}