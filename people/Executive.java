

final class Executive extends Manager {
	
	private String title;
	
	public Executive(String name, int salary, int bonus, String title) {
		super(name, salary, bonus);
		this.title = title;
	}
	
	public static void main(String[] args) {
		Executive bob = new Executive("bob", 1000000, 2000000, "the builder");
		System.out.println(bob.getSalary());
	}
	
}