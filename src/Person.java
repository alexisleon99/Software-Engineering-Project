import java.util.*;

public class Person {

	public static void main(String[] args) {		
		System.out.println("Enter what you would like to do");
		System.out.println("1 - Search Flights" + "\n2 - Purchase" + "\n3 - Cancel Reservation");
		Scanner input = new Scanner(System.in);
		
		int response = input.nextInt();
		
		if(response == 1){
			Reservation order = new Reservation();
			order.search();
			
		}else if(response == 2){
			
		}else if(response == 3) {
			
		}else {
			System.out.println("Command Not Recognised");
		}
			
	}
	
}
