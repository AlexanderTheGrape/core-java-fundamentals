package pizza;

import java.util.stream.*;
import java.util.stream.Collectors.*;

public class Calzone extends Pizza{
	
	private final boolean sauceInside;
	
	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauceInside = false; // Default
		
		public Builder sauceInside() {
			this.sauceInside = true;
			return this;
		}
		
		
		@Override public Calzone build() {
			return new Calzone(this);
		}
		
		@Override protected Builder self() {
			return this;
		}
	}
	
	private Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}
	
	public boolean getSauceInside() {
		return this.sauceInside;
	}
	
	public static void main(String[] args) {
		Calzone myCalzone = new Calzone.Builder()
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.PINEAPPLE)
			.sauceInside()
			.build();
		
		System.out.println(myCalzone.getSauceInside());
		System.out.println(myCalzone.getToppings().stream().map(Object::toString).collect(Collectors.joining(" ")));
		
		Pizza myPizza = new Calzone.Builder()
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.PINEAPPLE)
			.sauceInside()
			.build();
			
		System.out.println(myPizza.toString());
		
		// TODO mESS with the access modifiers in Pizza.java
		// TODO try reducing down the imports in this file to just the ones I need (no wildcards)
		// TODO try having these files in a package, try importing packages
	}
	
	
}