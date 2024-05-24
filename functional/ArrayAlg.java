

class ArrayAlg {
	
	record MinAndMax (int min, int max) { // TODO review end of record documentation in java
		public String toString() {return "min is: " + min + "max is: " + max;}
	}

	public static MinAndMax computeMinAndMax(int[] values) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int val: values) {
			if (val < min) min = val;
			if (val > max) max = val;
		}
		
		MinAndMax minAndMaxRecord = new MinAndMax(min, max);
		return minAndMaxRecord;
	}
	
	public static void main(String[] args) {
		System.out.println(ArrayAlg.computeMinAndMax(new int[] {5, 10, 6}));
	}

}