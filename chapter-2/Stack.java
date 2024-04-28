import java.util.Random;
import java.util.EmptyStackException;
import java.util.Arrays;

/** Stack class - simulates a stack, with basic operations.
* There is a memory leak, can you spot it?
* @author AlexanderTheGrape
* @version 0.0.1
* @see java.util.EmptyStackException
*/
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	/**
	* Create a Stack of default size
	*/
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	/**
	* Push an object to the stack
	* @param e object the object to be pushed to the stack
	*/
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	/**
	* Pop - Remove and return the top object from the stack
	* There is a memory leak, can you spot it?
	* @return the object on the top of the stack
	*/
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}
	
	private void ensureCapacity() {
		if(elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	/**
	* The main method to run, which will demonstrate the functionality of the Stack class
	* @param args empty string array
	*/
	public static void main(String[] args) {
		
		Stack bigStacc = new Stack();
		bigStacc.causeBigMemoryLeak();
	}
	
	private void causeBigMemoryLeak() {
		Random randomGenerator = new Random();
		for(double i = 0; i < Integer.MAX_VALUE; i++){
			double newDouble = randomGenerator.nextDouble();
			this.push(newDouble);
			
			//this.pop();
		}
	}
}