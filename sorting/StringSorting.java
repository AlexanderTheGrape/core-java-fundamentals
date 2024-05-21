import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;

class StringSorting
		implements Comparator<String> {
			
	public StringSorting(){}
		
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}	
	
	public static void main(String[] args) {
		String[] strArr = {"ab", "bbb", "cb"};
		String[] strArr2 = {"yy", "zzz", "x"};
		String[] strArr3 = {"a", "y", "x"};
		String[] strArr4 = {"1", "2", "3"};
		
		StringSorting comparator = new StringSorting();
		Arrays.sort(strArr, comparator);
		System.out.println(comparator.compare(strArr[0], strArr[1]));
		System.out.println(Arrays.asList(strArr).toString());
		Arrays.sort(strArr2, comparator);
		System.out.println(Arrays.asList(strArr2).toString());
		Arrays.sort(strArr3, comparator);
		System.out.println(Arrays.asList(strArr3).toString());
		Arrays.sort(strArr4, comparator);
		System.out.println(Arrays.asList(strArr4).toString());
		
		strArr = new String[]{"ab", "bbb", "cb"};
		Arrays.sort(strArr, (s1, s2) -> s1.length() - s2.length());
		System.out.println(Arrays.asList(strArr).toString());
		
		ArrayList arrList = new ArrayList<>(Arrays.asList(strArr));
		arrList.removeIf(e -> e == "ab");
		System.out.println(arrList);
		
		strArr = new String[]{"ab", null, "cb"};
		arrList = new ArrayList<>(Arrays.asList(strArr));
		arrList.removeIf(Objects::isNull); // Class::instanceMethod
		System.out.println(arrList);
	}
	
}