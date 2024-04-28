class Number6 {
	
	public static void main(String[] args) {
		System.out.println(sum());
	}
	
	private static Long sum() {
		Long sum = 0L;
		
		for(long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}