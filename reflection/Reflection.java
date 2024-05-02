import java.util.Scanner;

class Reflection {
	
	public static Object createGenericArrayOfUserGivenType() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the complete classname of the array type to create:");
		String uncheckedStr = sc.next();
		
		// Create a class of given fully qualified name for a class, throw error if invalid
		Class unknownClass = null;
		Object myArray = null;
		try {
			unknownClass = Class.forName(uncheckedStr);
			// Create array of given class type
			myArray = java.lang.reflect.Array.newInstance(unknownClass, 10);
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO throw an exception
			throw new Exception();
		}
		
		return myArray;
	}
	
	public static void main(String[] args) throws Exception {
		Object arr = createGenericArrayOfUserGivenType();
		System.out.println(((List<java.util.Arrays.asList(arr)).toString());
		System.out.println(arr.toString());
	}
	
}