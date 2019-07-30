import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
/**
 * This class implements a simple object of person.
 * <p>
 * This person object is used to save the information regarding any person who wishes
 * to purchase a flight.
 * </P>
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 *
 */

public class Person extends Login {

	String fname,lname,ssn;
	private Cancelation cancel;
	private List<Companion> companions;
	double budget;  
	private List<Flight> flights;
	Scanner input = new Scanner(System.in);
	/**
	 * Constructor that constructs the person object
	 * @param fname First name of the user
	 * @param lname Last name of the user
	 * @param ssn Social security of the user
	 * @param budget Budget that the user may spend on the flight
	 */
	public Person(String fname, String lname,String ssn, double budget) {
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
		this.budget = budget;
	}

	public String getName() {
		this.fname = fname; 
		this.lname = lname; 
		String name = fname + " " + lname;
		return name;
	}
 
	/**
	 * Method simply returns the users SSN
	 * @param ssn Its the SSN of the person
	 * @return the SSN of the person
	 */
	public String getSsn () {
		return ssn; 
	}
	/**
	 * This is the menu that the user interacts with in order to 
	 * find/search/purchase his/her flights
	 * @return 
	 * @throws IOException Throw a IO exception if the input our output fails
	 * @throws ParseException 
	 */
	public String menu () throws IOException, ParseException {	
		System.out.println("\nhello " + fname + " what would you like to do?");
		System.out.println("1 - Search Flights" + "\n2 - Cancel Reservation" + "\n3 - Reschedule");
		
		String response = input.next();
		
		if(response.equals("1") || response.equals("search") || response.equals("Search") ){
			System.out.println("Search for airline");
			System.out.println("Current Airlines are delta and jetblue");
			String airline = input.next();
			if(airline.equals("delta")) {
				int [] capacity =  {525,220,300,450,200,350};	
				Flight order = new Flight(airline,fname,ssn,budget);
				order.lists(airline);
				Airlines.list(locations,capacity);
				order.search();
			}else if(fname.equals("jetblue")) {
				int [] capacity =  {450,370,175,350,445,350};
				Flight order = new Flight(airline,fname,ssn,budget);
				order.lists(airline);
				Airlines.list(locations,capacity);
			}
			
		}else if(response.equals("2") || response.equals("cancel") || response.equals("Cancel") ){
			System.out.println("Going to Cancel Reservation");
			cancelMenu(ssn);
			
			//Cancelation.cancel(ssn);
		}else if(response.equals("3") || response.equals("Reschedule") || response.equals("reschedule")){
			System.out.println("Going to Reschedule Reservation");
			cancelMenu(ssn);
		}else {
			System.out.println("Command Not Recognized");
			System.exit(0);
		}		
		input.close();
		return response;
	} 
	
	/**
	 * This is a menu that is soley for canceling/rescheduling one's reservation.
	 * 
	 * @param ssn This is required for finding those files
	 * @return Returns what action the user has decided to do.
	 * @throws IOException an exception is thrown if there is a problem with the input.
	 * @throws ParseException an exception is thrown if there is a problem down the line with the dates.
	 */
	
	
	public String cancelMenu(String ssn) throws IOException, ParseException {
		System.out.println("Hello will you like to cancel or reschedule");
		System.out.println("Type 'cancel' to cancel flight or Type 'reschedule'");
		String interaction = input.next();
		
		if(interaction.equals("cancel")){
			Cancelation.cancel(ssn);
			Cancelation.refund(ssn);
		}else if(interaction.equals("reschedule")) {
			Cancelation.reschedule(ssn);
		}
		return interaction;
	}
}

