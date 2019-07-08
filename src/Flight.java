import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Flight {
	String airline;
	String fname;
	String ssn;
	double budget;

	public Flight(String airline, String fname,String ssn, double budget) {
		this.airline = airline;
		this.fname = fname;
		this.ssn = ssn;	
		this.budget = budget;
	}
	public void search() throws IOException {
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
		System.out.println("1 - YES Reserve" + "\n2 - NO Just looking around");
		int answer = input.nextInt();
		
		if(answer == 1) {
			Reservation ticket = new Reservation(airline,size,flight,fname,ssn, budget); 
			ticket.purchase();
		}else {
			System.out.println("Thank you for searching through " + airline + " flights");
		}
		input.close();	
	}	
}