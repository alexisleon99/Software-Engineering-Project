import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Person {
	String fname,lname,ssn;
	int birthDay;
	double budget;  
	
	/**
	 * Constructor that constructs the person object
	 * @param fname First name of the user
	 * @param lname Last name of the user
	 * @param ssn Social security of the user
	 * @param budget Budget that the user may spend on the flight
	 */
	public Person(String fname, String lname,String ssn, double budget) {
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
		this.budget = budget;
	}

	public String getName(String fname, String lname) {
		this.fname = fname; 
		this.lname = lname; 
		String name = fname + " " + lname;
		return name;
	}
 
	public int getBday (int birthDay) {
		return birthDay; 
	}
	/**
	 * Method simply returns the users SSN
	 * @param ssn
	 * @return
	 */
	public int getSsn (int ssn) {
		return ssn; 
	}
	/**
	 * This is the menu that the user interacts with in order to 
	 * find/search/purchase his/her flights
	 * @throws IOException
	 */
	public void menu () throws IOException {
		System.out.println("\nhello " + fname + " what would you like to do?");
			
		System.out.println("1 - Search Flights" + "\n2 - Purchase" + "\n3 - Cancel Reservation");
		Scanner input = new Scanner(System.in);
		
		int response = input.nextInt();
		
		if(response == 1){
			System.out.println("Search for airline");
			String airline = input.next();
			Flight order = new Flight(airline,fname,ssn,budget);
			order.search();
		}else if(response == 2){
			System.out.println("Direclty purchasing ticket");
			
			//Reservation directp = new Reservation(fname, input, null, null, budget);
			//directp.directp();
		}else if(response == 3){
			System.out.println("Command not yet added");
			System.exit(0);
		}else {
			System.out.println("Command Not Recognized");
			System.exit(0);
		}		
		input.close();
	} 
}