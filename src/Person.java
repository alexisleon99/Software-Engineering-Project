import java.io.FileNotFoundException;
import java.io.IOException;
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
public class Person {
	private Flight Flight;
	String fname,lname,ssn;
	//int birthDay;
	double budget;  
	
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
	 */
	public int menu () throws IOException {
		
		System.out.println("\nhello " + fname + " what would you like to do?");
		System.out.println("1 - Search Flights" + "\n2 - Cancel Reservation" + "\n3 - Reschedule");
		Scanner input = new Scanner(System.in);
		int response = input.nextInt();
		
		
		
		if(response == 1){
			System.out.println("Search for airline");
			System.out.println("Current Airlines are delta and jetblue");
			String airline = input.next();
			
			
			
			Flight order = new Flight(airline,fname,ssn,budget);
		}else if(response == 2){
			System.out.println("Going to Cancel Reservation");
			
			Cancelation.cancel(ssn);
		}else if(response == 3){
			System.out.println("Going to Reschedule Reservation");
			Cancelation.reschedule(ssn);
		}else {
			System.out.println("Command Not Recognized");
			System.exit(0);
		}		
		input.close();
		return response;
	} 
	
}

