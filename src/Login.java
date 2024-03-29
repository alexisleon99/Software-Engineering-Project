import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
/**
 * This is the actor/class where the program begins
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 *
 */
public class Login {
	private static Person Person;
	static HashMap <String,Double> locations = new HashMap();
	static int [] capacity;
	
	/**
	 * This is the main method where the user 
	 * is prompted to enter some credentials needs for 
	 * his/her flight reservation.
	 * If it is an airline that is using the system, the airline
	 * simply needs to enter in their airline name as the first name
	 * and it will print out their flight destinations along with the flights capacity.
	 * This part of the program also asks the user/person if they will like to cancel
	 * or reschedule their flight.
	 * @param args Simply the arguments line
	 * @throws IOException An exception that is thrown
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello welcome to Atlanta International Airport");
		System.out.println("Please sign in");
		System.out.println("Enter First Name");
		String fname = input.next();
		if(fname.equals("delta")) {
			int [] capacity =  {525,220,300,450,200,350};	
			Flight.lists(fname);
			Airlines.list(locations, capacity);
			
		}else if(fname.equals("jetblue")) {
			int [] capacity =  {450,370,175,350,445,350};	
			Flight.lists(fname);
			Airlines.list(locations, capacity);
			
		}else {
			System.out.println("Enter last Name");
			String lname = input.next();
			
			System.out.println("Enter SSN");
			String ssn = input.next();
			
			System.out.println("Are you here for a cancelation/reschedule");
			System.out.println("Enter a yes or a 1 to confirm enter anything else to continue");
			String response = input.next();
			
			if(response.equals("yes") || response.equals("1") || response.equals("Yes")) {
				int budget = 0;
				Person user = new Person(fname, lname, ssn, budget);
				user.cancelMenu(ssn);

				System.exit(0);
			}else {
				System.out.println("Please enter your budget for your flight");
				double budget = input.nextDouble();
				Person user = new Person(fname, lname, ssn, budget);
				System.out.println();
				user.menu();
				input.close();	
			}	
		}
		
		
		
	}
}
