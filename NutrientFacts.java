import PizzaPackage.Pizza;

public class NutrientFacts {

	private final int servingSize;
	private final int servings;
	
	private final int calories;
	private final int fat;
	private final Pizza pizza;
	
	public int getServings() {
		return this.servings;
	}
	
	public static class Builder {
		// Required parameters
		private final int servingSize;
		private final int servings;
		
		// Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		
		private Pizza pizza;
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}
		
		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}
		
		public NutrientFacts build() {
			return new NutrientFacts(this);
		}
	}
	
	private NutrientFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
	}
	
	public static void main(String[] args) {
		System.out.println("hello, this works");
		
		NutrientFacts myNutrients = new NutrientFacts.Builder(1, 4).calories(50).fat(10).build();
			
		System.out.println(myNutrients.toString());
		System.out.println(myNutrients.getServings());
	}
}