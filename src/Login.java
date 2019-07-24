import java.io.FileNotFoundException;
import java.io.IOException;
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
	static HashMap <String,Double> map = new HashMap();
	/**
	 * This is the main method where the user 
	 * is prompted to enter some credentials needs for 
	 * his/her flight reservation
	 * @param args Simply the arguments line
	 * @throws IOException An exception that is thrown
	 */
	public static void main(String[] args) throws IOException {	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello welcome to Atlanta International Airport");
		System.out.println("Please sign in");
		System.out.println("Enter First Name");
		String fname = input.next();
		
		if(fname.equals("delta")|| fname.equals("jetblue")) {
			Flight.lists(fname);
			Airlines.list(map);
		}else {
			System.out.println("Enter last Name");
			String lname = input.next();
			
			System.out.println("Enter SSN");
			String ssn = input.next();
			
			System.out.println("Are you here for a cancelation/reschedule");
			String response = input.next();
			

			if(response.equals("yes")) {
				int budget = 0;
				Person user = new Person(fname, lname, ssn, budget);
				user.cancelMenu(ssn);

				System.exit(0);
			}else {
				System.out.println("Please enter your budget for your flight");
				double budget = input.nextDouble();
				Person user = new Person(fname, lname, ssn, budget);
				user.menu();
				input.close();	
			}	
		}
		
		
		
	}
}
