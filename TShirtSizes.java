

class TShirtSizes {

	public enum Size {
		SMALL("for lil dudes"),
		MEDIUM("for Joe dudes"),
		LARGE("for big dudes"),
		EXTRA_LARGE("for mega dudes");
		
		private String description;
		
		Size(String description) {
			this.description = description;
		}
		
		public String getYoCoolDesc(){
			return description;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Size.SMALL.toString());
		System.out.println(Size.EXTRA_LARGE.getYoCoolDesc());
		System.out.println(Size.SMALL.ordinal());
		System.out.println(Size.MEDIUM.ordinal());
		System.out.println(Size.EXTRA_LARGE.ordinal());
		System.out.println(Size.SMALL.compareTo(Size.LARGE));
		System.out.println(Size.EXTRA_LARGE.compareTo(Size.LARGE));
	}

}