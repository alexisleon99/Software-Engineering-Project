import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Flight {
	private Reservation Reservation;
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

		Scanner input = new Scanner(System.in);
		HashMap <String,Double> map = new HashMap();
		
		if(airline.equals("delta")) {
			map.put("Austin", (double) 3500);
			map.put("Portland", (double) 4500);
			map.put("Chicago", (double) 3800);
			map.put("Miami", (double) 3200);
			map.put("New York", (double) 3000);
			map.put("Arizona", (double) 5000);	
			System.out.println(map);
		}else if(airline.equals("jetblue")){
			map.put("Mexico", (double) 3500);
			map.put("Canada", (double) 4500);
			map.put("Bali", (double) 3800);
			map.put("Japan", (double) 3200);
			map.put("Brazil", (double) 3000);
			map.put("United Kingdom", (double) 5000);	
			System.out.println(map);
		}else {
			System.out.println("Airline not with airport");
		}
		
		System.out.println("Will you like to purchase a reservation to one of these destinations?");
		System.out.println("1 - YES Reserve" + "\n2 - NO Just looking around");
		
		String answer = input.next();
		
		if(answer.equals("yes")) {
			
			Reservation ticket = new Reservation(airline,fname,ssn, budget,map); 
			ticket.purchase();
		}else {
			System.out.println("Thank you for searching through " + airline + " flights");
			System.exit(0);
		}
		input.close();
	}	
}