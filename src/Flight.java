import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Flight {
	
	String destination;
	String fnum;
	int capacity;
	double price;

	public Flight(String destination) {
		this.destination = destination;
		
	}
	
	public void search() throws FileNotFoundException {
		
		System.out.println("Search for airline");
		Scanner input = new Scanner(System.in);
		
		String airline = input.next();
		
		System.out.println("Destination");
		File file = new File("src\\"+airline+".txt"); 
		Scanner flight = new Scanner(file); 
		  
		while (flight.hasNextLine()) {
			System.out.println(flight.nextLine()); 
		 }
		flight.close();
		input.close();
		
	}
	
}
