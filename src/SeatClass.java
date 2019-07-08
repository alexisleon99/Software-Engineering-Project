import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeatClass {
	double cost;
	
	public SeatClass(double cost){
		this.cost = cost;
	}
	
	Scanner seat = new Scanner(System.in);
	
	public void chooser(Double cost) throws FileNotFoundException{
		
		System.out.println("Please choose what type of seat you will Like");
		String type = seat.next();
		if(type.equals("First")) {
			cost = cost * 2;
			Reservation.finalizePurchase(cost);
		}else if(type.equals("Business")) {
			cost = cost * 1.5;
			Reservation.finalizePurchase(cost);
		}else if(type.equals("Economoy")) {
			Reservation.finalizePurchase(cost);
		}
		
	}
	

}
