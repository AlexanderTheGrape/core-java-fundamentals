import java.util.Scanner;

class Reflection {
	
	public static Array<?> createGenericArrayOfUserGivenType() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the complete classname of the array type to create:");
		String uncheckedStr = sc.next();
		
		// Create a class of given fully qualified name for a class, throw error if invalid
		Class unknownClass = null;
		try {
			unknownClass = Class.forName(uncheckedStr);
		} catch (LinkageError|ExceptionInInitializerError|ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		// Create array of given class type
		Array<?> myArray = java.util.reflect.Array.newInstance(unknownClass, 10);
	}
	
	public static void main(String[] args) {
		Array<?> arr = createGenericArrayOfUserGivenType();
		System.out.println(java.util.Arrays.toList(arr));
	}
	
}