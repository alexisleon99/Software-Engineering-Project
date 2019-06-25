import java.io.FileNotFoundException;
import java.util.*;

public class Person {

	public static void main(String[] args) throws FileNotFoundException {		
		System.out.println("Enter what you would like to do");
		System.out.println("1 - Search Flights" + "\n2 - Purchase" + "\n3 - Cancel Reservation");
		Scanner input = new Scanner(System.in);
		
		int response = input.nextInt();
		
		if(response == 1){
			Flight order = new Flight(null);
			order.search();
		}else if(response == 2){
			System.out.println("Command not yet added");
			System.exit(0);
		}else if(response == 3){
			System.out.println("Command not yet added");
			System.exit(0);
		}else {
			System.out.println("Command Not Recognized");
			System.exit(0);
		}
		
		main(args);
		input.close();
	}
	
}
