import java.io.*;
import java.util.*;

/**
 *  * This class implements a simple object of Reservation.
 * <p>
 * This class is where the user finishes and recieves his/her ticket in the form of a txt file.
 * </P>
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 *
 */
public class Reservation {
	private Seat Seat;
	static String airline;
	static String fname;
	static String ssn;
	static HashMap map;
	static double budget;
	static Scanner input = new Scanner(System.in);
	
	/**
	 * This constructs the Reservations with the first name, his/her budget
	 * the airline, and txt file of flights he/her may go to
	 * @param airline that the user chooses
	 * @param fname The first name of the user
	 * @param ssn The Social Security number of the User
	 * @param budget The amount the user may spend on his/her flight
	 * @param map This is what contains the flight along with the price
	 */
	public Reservation(String airline, String fname, String ssn, double budget,HashMap map) {
		this.airline = airline;
		this.map = map;
		this.fname = fname;
		this.ssn = ssn;
		this.budget = budget;
	}

	/**
	 * In this method it prompts the user to enter what location/destination will like to go to
	 *<p>
	 * It also passes the cost and the location of their visit to the seat class
	 * where it determines the total cost for the trip.
	 *</p>
	 * @return 
	 * @throws IOException throws the exception when the input is failed to be interpreted
	 */
	public static double purchase(String string) throws IOException {
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
		System.out.println("Choose which location you will like to visit");
		String visit = input.nextLine();
		
		if(string.equals(visit)) {
			Double cost =  (Double) map.get(visit);
			Seat type = new Seat(cost,visit);
		}
		
		if(map.containsKey(visit)) {
			Double cost =  (Double) map.get(visit);
			Seat type = new Seat(cost,visit);
			type.SeatClass(visit);	
			return cost;
		}else {
		return 0;
		}
		
	}
	
	/**
	 * This method simply determines if the user has enough funds in order to continue with the 
	 * reservation process.
	 * <p>
	 * If the user has more than enough within in their budget the program simply continues
	 * However, the program with terminate if the user does not have enough funds.
	 * </p>
	 * @param cost Total cost of the trip to help determine if the user has sufficient funds
	 * @param budget The budget that the user is willing to spend on the flight.
	 */
	public static double CashCheck(Double cost, double budget){
		double balance = budget - cost;
		System.out.println("Your Budget is " + budget);
		System.out.println("Flight Cost is " + cost);

		if(balance < 0) {
			System.out.println("Sorry sir/mam you do not have sufficient funds");
			System.exit(0);
		}
		return balance;
	}
	
	/**
	 * In this method the user will recieve notice that the their reservation was a success.
	 * <p>
	 * It created a txt document called reservations with some of the users information.
	 * This serves as the users receipt/ticket for their flight.
	 * </p>
	 * @param cost This is the total cost of the flight.
	 * @param row This is the Letter that will be given to the user to find their seat.
	 * @param number Along with row this helps the user find their seat.
	 * @param visit This is the location of their visit.
	 */
	public static void FinalizePurchase(double cost, char row, int number, String visit){
		//int count++;
		double balance;
		CashCheck(cost,budget);
		balance = budget - cost;
		
		String filename = "reservations"+ssn+".txt";
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		outputStream.println("***Reservation"+ ssn +"List***");
		outputStream.printf("%-10s%-12s%-16s%4s%10s","SSN", "First Name", " Destination", "Seat", "Balance");
		outputStream.println();
		outputStream.printf("%-10s%-13s%-15s%1c%-5d%8.2f",ssn,fname,visit,row,number,balance);
		outputStream.close();
		
		System.out.println("reservation was a success enjoy your flight");	
	}
}
