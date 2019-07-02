import java.io.FileNotFoundException;
import java.util.*;

public class Login {

	public static void main(String[] args) throws FileNotFoundException {	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello welcome to Atlanta International Airport");
		System.out.println("Please sign in");
		System.out.println("Enter First Name");
		String fname = input.next();
		System.out.println("Enter last Name");
		String lname = input.next();
		System.out.println("Enter SSN");
		String ssn = input.next();
		
		Person user = new Person(fname, lname, ssn);
		user.menu();
		input.close();
		
	
	}
}
