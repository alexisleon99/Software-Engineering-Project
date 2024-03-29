import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
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
	
	//private static Reservation Reservation;
	static String airline;
	String fname;
	static String ssn;
	double budget;
	private List<Reservation> reservations;
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

	/**
	 * This Method adds a number of companions to the person in order to go on a flight. Along with 
	 * adding companions to person this method will create tickets for each new companion.
	 * 
	 * <p> 
	 * with each new companion budget from the original person will be decreased and will be checked 
	 * to see if the person has enough money left over to book their companions flight.
	 * </p>
	 *  
	 * 
	 * @param airlines Is the airline in which has been chosen
	 * @param budget Is the Budget that person/user has
	 * @param locations The Destinations they may go
	 * @param answer The Chosen Destination
	 * @param cost The Price of their flight 
	 * @throws IOException
	 * @throws ParseException
	 * 
	 * @see Reservations 
	 */
	public static void addCompanion(String airlines,double budget,HashMap locations,String answer, double cost) throws IOException, ParseException {
		System.out.println("reservation was a success enjoy your flight");	
		System.out.println("Would you like to add companions?");
		System.out.println("1 - yes" + "\n2 - no");
		String answer2 = input.next();
		
		if(answer2.equals("1") || answer2.equals("yes") || answer2.equals("Yes")) {
			System.out.println("How many companions will be accompanying you?");
			
			int num = input.nextInt();
			cost = cost * num;
			Reservation.CashCheck(cost, budget);
			
			for(int i = 1;i <= num; i++) {
				System.out.println("current budget is " + budget);
				String companion = "companion" + i;
				String newSsn = ssn + i;
				Reservation ticket2 = new Reservation(airline,companion,newSsn, budget,locations);
				ticket2.purchase(answer,newSsn);
			}
		}
		else {
			System.out.println("No companions");
		}
	}
	
	/**
	 * This method only adds the flights to the designated airline(Data Structure)
	 * @param airline is the string argument given to the method in order to select which data
	 * is entered into the data structure.
	 * @return A HashMap with the resulting data according to the argument given to the method.
	 */
	public static HashMap lists(String airline) {
		if(airline.equals("delta")) {
			locations.put("Austin", (double) 3500);
			locations.put("Portland", (double) 4500);
			locations.put("Chicago", (double) 3800);
			locations.put("Miami", (double) 3200);
			locations.put("New York", (double) 3000);
			locations.put("Arizona", (double) 5000);	
		}else if(airline.equals("jetblue")){
			locations.put("Mexico", (double) 3500);
			locations.put("Canada", (double) 4500);
			locations.put("Bali", (double) 3800);
			locations.put("Japan", (double) 3200);
			locations.put("Brazil", (double) 3000);
			locations.put("United Kingdom", (double) 5000);

		}else {
			System.out.println("Airline not with airport");
			System.exit(0);
		}
		return locations;//needed return statement in order for testing
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
	 * once the person has chosen an airline and looked at the available flight, they will be asked to 
	 * make a reservation or just say that they are looking around.
	 * </p>
	 * <p>
	 * If person chooses to make a reservation, the search method will create an object of reservation 
	 * using the airline, first name, SSN, budget, and the map data structure for tickets
	 * </p>
	 * @return 
	 * 
	 * 
	 * @throws IOException Used in case of the an IO error and is handled to allow program form crashing.
	 * @throws ParseException 
	 */
	public void search() throws IOException, ParseException {
		
		System.out.println("Will you like to purchase a reservation to one of these destinations?");
		System.out.println("1 - yes" + "\n2 - NO Just looking around");
		
		String answer = input.next();
		
		if(answer.equals("yes") || answer.equals("Yes") || answer.equals("1")) {
			Reservation ticket = new Reservation(airline,fname,ssn, budget,locations); 
			ticket.purchase(answer,ssn);
			
		}else {
			System.out.println("Thank you for searching through " + airline + " flights");
			System.exit(0);
		}
		input.close();
	}	
}

