import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Flight {
	String airline;

	public Flight(String airline) {
		this.airline = airline;
		
	}
	public void search() throws FileNotFoundException {
		int size = 0;
		Scanner input = new Scanner(System.in);
		
		File file = new File("src\\"+airline+".txt"); 
		Scanner flight = new Scanner(file); 
		  
		
		while (flight.hasNextLine()) {
			System.out.println(flight.nextLine());
			size++;
		}
		
		flight.close();
		System.out.println("Will you like to purchase a reservation to one of these destinations?");
		int answer = input.nextInt();
		
		if(answer == 1) {
			Reservation ticket = new Reservation(airline,size,flight); 
			ticket.purchase();
		}else {
			System.out.println("Thank you for searching through " + airline + " flights");
		}
		
		input.close();
		
	}
	
}

