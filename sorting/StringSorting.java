

static class StringSorting {
	
	static class SortStringByLengthComparator implements Comparator{
		static int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}	
	
	public static void main(String[] args) {
		String[] strArr1 = new String[]{"a", "b", "c"};
		String[] strArr2 = new String[]{"x", "y", "z"};
		String[] strArr3 = new String[]{"a", "y", "x"};
		String[] strArr3 = new String[]{"1", "2", "3"};
	}
	
}