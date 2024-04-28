import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class TextFileReader {

	public static void readTextFile(String fileName) {
		
		try {
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				System.out.println(nextLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error!: " + e);
		}
		
	}
	
	public static void main(String[] args) {
		TextFileReader.readTextFile("resources/testTextFile.txt");
	}

}