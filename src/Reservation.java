import java.io.*;
import java.util.*;

/**
 * 
 * @author Jose Delgado
 *
 */
public class Reservation {
	String airline;
	static String fname;
	static String ssn;
	HashMap map;
	static double budget;
	Scanner input = new Scanner(System.in);
	
	/**
	 * This constructs the Reservations with the first name, his/her budget
	 * the airline, and txt file of flights he/her may go to
	 * @param airline that the user chooses
	 * @param size
	 * @param fname The first name of the user
	 * @param ssn The Social Security number of the User
	 * @param budget The amount the user may spend on his/her flight
	 */
	public Reservation(String airline, String fname, String ssn, double budget, HashMap map) {
		this.airline = airline;
		this.map = map;
		this.fname = fname;
		this.ssn = ssn;
		this.budget = budget;
	}

	public void purchase() throws IOException {
		double balance = 0;
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
			
		System.out.println("Choose which location you will like to visit");
		String visit = input.nextLine();
		
		if(map.containsKey(visit)) {
			Double cost =  (Double) map.get(visit);
			Seat type = new Seat(cost,visit);
			type.SeatClass(cost,visit);		
		}
	}
	
	/*public void directp() throws IOException {
		System.out.println("hello sir/mam");
		System.out.println("Please choose your desired airline");
		String airline = input.next();
		

		
		System.out.println("Choose which location you will like to visit");
		String visit = input.next();
		System.out.println(visit);
		
		int count = 0;
		String filename = "reservations.txt";
		PrintWriter outputStream = new PrintWriter(filename);

		if(count ==0) {
			System.out.println("Sorry Sir/Mam that destination is not being traveled to by that Airline");
		}
	}*/
	
	public static void cashcheck(Double cost, double budget){
		System.out.println("Your Budget is " + budget);
		System.out.println("Flight Cost is " + cost);
		
		double balance = budget - cost;
		
		if(balance < 0) {
			System.out.println("Sorry sir/mam you do not have sufficient funds");
			System.exit(0);
		}
	}
	
	public static void finalizePurchase(double cost, char row, int number, String visit) throws FileNotFoundException {
		double balance;
		cashcheck(cost,budget);
		balance = budget - cost;
		
		String filename = "reservations.txt";
		PrintWriter outputStream = new PrintWriter(filename);
		
		outputStream.println("***Reservation List***");
		outputStream.println("SSN\t" + "First Name\t" + "Destination" + "\tSeat" + "\tBalance");
		outputStream.println(ssn + "\t" + fname + "\t" + visit + "\t" + row + number + "\t" + balance);
		outputStream.close();
		
		System.out.println("reservation was a success enjoy your flight");	
	}
}
