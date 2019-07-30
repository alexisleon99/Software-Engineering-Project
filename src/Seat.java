import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
/**
 * This implements a object of Seat type, which is used to choose the seat type when purchasing a 
 * flight
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 */
public class Seat {
	private static Reservation Reservation;
	static double cost;
	String visit;
	/**
	 * This constructor is used in order to create the seat object.
	 * @param cost This is the cost of the flight chosen.
	 * @param visit this is the destination of the flight.
	 */
	public Seat(double cost, String visit){
		this.cost = cost;
		this.visit = visit;
	}
	static Scanner seat = new Scanner(System.in);
	/**
	 * The seatClass method will ask the person when making a reservation which type of seat they 
	 * would like. 
	 * <p>
	 * The person can choose between First, Business, or Economy class.
	 * </p>
	 * @param cost This is the cost of the flight that was chosen by the person to the certain
	 * Destination.
	 * @param visit This is the destination that was chosen.
	 * @param answer 
	 * @param ssn 
	 * @return 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	
	public String SeatClass(String visit, String answer, String ssn) throws IOException, ParseException{
		System.out.println("Please choose what type of seat you will Like");
		System.out.println("1 - First" + "\t" + "2 - Business" +"\t" + "3 - Economy");
		String type = seat.next();
		if(type.equals("First") || type.equals("first") || type.equals("1")) {
			cost = cost * 2;
			SeatChart(cost,visit,answer,ssn);
		}else if(type.equals("Business") || type.equals("business") || type.equals("2")) {
			cost = cost * 1.5;
			SeatChart(cost,visit,answer,ssn);
		}else if(type.equals("Economy") || type.equals("economy") || type.equals("3")) {
			SeatChart(cost,visit,answer,ssn);			
		}
		else {
			System.out.println("Sorry that is not a seat type please enter a valid one");
			SeatClass(visit, answer, ssn);
		}
		return type;
	}
	/**
	 * This method will be used in order to assign a randomized row and seat letter.
	 * @param cost This is the cost of the flight.
	 * @param visit This is the destination of the flight.
	 * <p>
	 * once the row and seat letter has been generated it will call the last method the 
	 * FinalizePurchase method
	 * </p>
	 * @param answer 
	 * @param ssn 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void SeatChart(double cost,String visit, String answer, String ssn) throws IOException, ParseException {
		Random r = new Random();
		int letter = r.nextInt(90 - 65) + 65;
		char row = (char)letter;
		int number = r.nextInt(100);
		Reservation.FinalizePurchase(cost, row, number,visit,answer,ssn);
	}
}