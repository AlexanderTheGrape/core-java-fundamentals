package pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
	
	public enum Topping { HAM, CHEESE, ONION, TOMATO, PINEAPPLE }
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>> {
		
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		// Subclasses must override this method to return "this"
		protected abstract T self();
	}
	
	protected Pizza(Builder<?> builder) { // try making this protected TODO
		toppings = builder.toppings.clone();
	}
	
	public Set<Pizza.Topping> getToppings() {
		return this.toppings;
	}
	
	//public String toString() {
	//	return "gotcha!";
	//}

}