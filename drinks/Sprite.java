package drinks;

class Sprite {
	
	public Sprite() {
	}
	
	record SpriteRecord(String flavour, int volumeMillilitres) {
		
		public SpriteRecord() { this("Lemonade", 375); }
		
	}
	
	public static void main(String[] args) {
	
		var myDrink = new SpriteRecord();
		System.out.println(myDrink.flavour);
		System.out.println(myDrink.volumeMillilitres);
		
	}
}
