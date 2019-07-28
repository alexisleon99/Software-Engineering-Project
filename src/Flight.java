import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class implements a simple flight object which is used to search and 
 * find flights of diffrent airlines.
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 * @version Sprint_1
 */
public class Flight extends Login {
	
	private static Reservation Reservation;
	static String airline;
	String fname;
	static String ssn;
	double budget;
	
	static Scanner input = new Scanner(System.in);
	/**
 * This constructs the Flight object with the airline, first name, SSN, and budget.
 * @param airline This is the airline from which the flight is being chosen from.
 * @param fname this is the first name of the person who wishes to take the flight.
 * @param ssn This is the social security number of the person.
 * @param budget This is the budget that the person has.
 */
	public Flight(String airline, String fname,String ssn, double budget) {
		this.airline = airline;
		this.fname = fname;
		this.ssn = ssn;	
		this.budget = budget;
	}
	/*public boolean equals(Flight obj) {
		if(this == obj)
		return true;
		else 
			return false;
	}*/
	
	
	public static void addCompanion(String airlines,double budget,HashMap map,String answer, double cost) throws IOException {
		System.out.println("reservation was a success enjoy your flight");	
		System.out.println("Would you like to add companions?");
		System.out.println("1 - yes" + "\n2 - no");
		
		int answer2 = input.nextInt();
	if(answer2 == 1) {
			System.out.println("How many companions will be accompanying you?");
			
			int num = input.nextInt();
			cost = cost * num;
			Reservation.CashCheck(cost, budget);
			for(int i = 1;i<=num; i++) {
				System.out.println("current bduegt is "+ budget);
				String companion = "companion" + i;
				String newSsn = ssn+i;
				Reservation ticket2 = new Reservation(airline,companion,newSsn, budget,map);
				ticket2.purchase(answer);
			}
		}
		else {
			System.out.println("No companions");
		}
	}
	
	
	
	
	public static void lists(String airline) {
		
		//HashMap <String,Double> map = new HashMap();
		
		if(airline.equals("delta")) {
			map.put("Austin", (double) 3500);
			map.put("Portland", (double) 4500);
			map.put("Chicago", (double) 3800);
			map.put("Miami", (double) 3200);
			map.put("New York", (double) 3000);
			map.put("Arizona", (double) 5000);	
			//System.out.println(map);
		}else if(airline.equals("jetblue")){
			map.put("Mexico", (double) 3500);
			map.put("Canada", (double) 4500);
			map.put("Bali", (double) 3800);
			map.put("Japan", (double) 3200);
			map.put("Brazil", (double) 3000);
			map.put("United Kingdom", (double) 5000);	
			//System.out.println(map);
		}else {
			System.out.println("Airline not with airport");
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * <p>
	 * This search method allows the person to search the different flights
	 * The person will first be asked to which airline they wish to search for.
	 * </p>
	 * The results are returned depending on which airline they choose either delta or jetblue.
	 * If the person asks for an airline that is not part of the airport a message will be printed
	 * out stating this fact.
	 * <p>
	 * once the person has choosen an airline and looked at the available flight, they will be asked to 
	 * make a reservation or just say that they are looking around.
	 * </p>
	 * <p>
	 * If person chooses to make a reservation, the search method will create an object of reservation 
	 * using the airline, first name, ssn, budget, and the map data structure for tickets
	 * </p>
	 * @return 
	 * 
	 * 
	 * @throws IOException Used in case of the an IO error and is handled to allow program form crashing.
	 */
	public HashMap search() throws IOException {
		
		System.out.println("Will you like to purchase a reservation to one of these destinations?");
		System.out.println("1 - yes" + "\n2 - NO Just looking around");
		
		String answer = input.next();
		
		if(answer.equals("yes")) {
			Reservation ticket = new Reservation(airline,fname,ssn, budget,map); 
			//this returns a double type, shouldn't it be a void method
			ticket.purchase(answer);
			
		}else {
			System.out.println("Thank you for searching through " + airline + " flights");
			System.exit(0);
		}
		
		input.close();
		return map;

	}	
}

