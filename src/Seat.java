import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Seat {
	double cost;
	String visit;
	
	public Seat(double cost, String visit){
		this.cost = cost;
		this.visit = visit;
	}
	Scanner seat = new Scanner(System.in);
	
	public void SeatClass(Double cost, String visit) throws FileNotFoundException{
		System.out.println("Please choose what type of seat you will Like");
		String type = seat.next();
		if(type.equals("First")) {
			cost = cost * 2;
			SeatChart(cost,visit);
		}else if(type.equals("Business")) {
			SeatChart(cost,visit);
			cost = cost * 1.5;
		}else if(type.equals("Economoy")) {
			SeatChart(cost,visit);			
		}
	}
	
	public void SeatChart(double cost,String visit) throws FileNotFoundException {
		Random r = new Random();
		int letter = r.nextInt(90 - 65) + 65;
		char row = (char)letter;
		int number = r.nextInt(100);
		Reservation.finalizePurchase(cost, row, number,visit);
	}
}