

interface Sackable {
	
	boolean isSackable();
	
	default void sackEmployee() {
		throw new UnsupportedOperationException();
	}
	
	static void about() {
		System.out.println("I am an interface to help determine if an employee can be sacked");
	}
	
	default boolean shouldBeSacked() {
		return false;
	}
	
}