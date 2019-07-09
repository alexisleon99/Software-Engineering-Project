import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**
 * This implements a object of Seat type, which is used to choose the seat type when purchasing a 
 * flight
 * @author Alexis Leon
 * @see {@link Reservation}
 */
public class Seat {
	private Reservation Reservation;
	double cost;
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
	Scanner seat = new Scanner(System.in);
	/**
	 * The seatClass method will ask the person when making a reservation which type of seat they 
	 * would like. 
	 * <p>
	 * The person can choose between First, Business, or Economy class.
	 * </p>
	 * @param cost This is the cost of the flight that was chosen by the person to the certain
	 * Destination.
	 * @param visit This is the destination that was chosen.
	 * @throws FileNotFoundException
	 */
	public void SeatClass(Double cost, String visit) throws FileNotFoundException{
		System.out.println("Please choose what type of seat you will Like");
		System.out.println("First" + "/t" + "Business" +"/t" + "Economy");
		String type = seat.next();
		if(type.equals("First")) {
			cost = cost * 2;
			SeatChart(cost,visit);
		}else if(type.equals("Business")) {
			SeatChart(cost,visit);
			cost = cost * 1.5;
		}else if(type.equals("Economy")) {
			SeatChart(cost,visit);			
		}
	}
	/**
	 * This method will be used in order to assign a randomized row and seat letter.
	 * @param cost This is the cost of the flight.
	 * @param visit This is the destination of the flight.
	 * <p>
	 * once the row and seat letter has been randomized it will pass the 
	 * </p>
	 * @throws FileNotFoundException
	 */
	public void SeatChart(double cost,String visit) throws FileNotFoundException {
		Random r = new Random();
		int letter = r.nextInt(90 - 65) + 65;
		char row = (char)letter;
		int number = r.nextInt(100);
		Reservation.finalizePurchase(cost, row, number,visit);
	}
}