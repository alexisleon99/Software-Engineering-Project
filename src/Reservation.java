import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
	 * @throws java.text.ParseException 
	 */
	public static void purchase(String answer) throws IOException, java.text.ParseException {
		//why is this double?
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
		System.out.println("Choose which location you will like to visit");
		String visit = input.nextLine();
		
		if(answer.equals(visit)) {
			Double cost =  (Double) map.get(visit);
			Seat type = new Seat(cost,visit);
		}
		if(map.containsKey(visit)) {
			Double cost =  (Double) map.get(visit);
			Seat type = new Seat(cost,visit);
			type.SeatClass(visit,answer);
		}
		else {
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
		if(balance < 0.0) {
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
	 * At the end of the proccess the user has the option to add companions to go with him/her
	 * </p>
	 * @param cost This is the total cost of the flight.
	 * @param row This is the Letter that will be given to the user to find their seat.
	 * @param number Along with row this helps the user find their seat.
	 * @param visit This is the location of their visit.
	 * @param answer This is what passes to the addCompanion method it the users desired location
	 * @throws IOException 
	 * @throws java.text.ParseException 
	 */
	public static void FinalizePurchase(double cost, char row, int number, String visit, String answer) throws IOException, java.text.ParseException{
		CashCheck(cost,budget);
		budget = budget - cost;
		String filename = "reservations"+ssn+".txt";
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        System.out.println("Enter in departure in this format dd-M-yyyy hh:mm:ss");
        String departure = input.nextLine();
        try {
            Date newdate = dateformat2.parse(departure);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		outputStream.println("***Reservation"+ ssn +"List***");
		//outputStream.printf("%-10s%-12s%-16s%4s%10s%20s","SSN", "First Name", " Destination", "Seat", "Cost", "Departure");
		outputStream.println("SSN\t" + "First Name\t" + "Destination\t" + "Seat\t" + "Cost\t" + "Departure");
		outputStream.println();
		outputStream.println(ssn + "\t" + fname + "\t" +visit + "\t" + row + number + "\t" + "$\t" + cost + "\t" + departure );
		//outputStream.printf("%-10s%-13s%-15s%1c%-5d$%-8.2f%20s",ssn,fname,visit,row,number,cost,departure);

		if(fname.contains("companion")) {
		}else {
			Flight.addCompanion(airline,budget,map, answer,cost);
		}
		outputStream.close();
		System.out.println("Goodbye Have a Safe Trip");
	}
}
