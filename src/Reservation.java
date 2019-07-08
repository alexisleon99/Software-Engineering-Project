import java.io.*;
import java.util.*;

public class Reservation {
	String airline, fname, ssn;
	int size;
	Scanner flight2;
	double budget;
	Scanner input = new Scanner(System.in);
	public Reservation(String airline, int size, Scanner flight2,String fname, String ssn, double budget) {
		this.airline = airline;
		this.size = size;
		this.flight2 = flight2;
		this.fname = fname;
		this.ssn = ssn;
		this.budget = budget;
	}
	
	public void purchase() throws IOException {
		System.out.println(size);
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
		
		String [] destinations = null;
		FileReader read = new FileReader("src\\"+airline+".txt");
		BufferedReader br = new BufferedReader(read);
		String s = null;
		
		System.out.println("Choose which location you will like to visit");
		String visit = input.nextLine();
		
		//cashcheck(destinations,br,visit,s);
		
		
		int count = 0;
		String filename = "reservations.txt";
		PrintWriter outputStream = new PrintWriter(filename);
		while((s=br.readLine()) !=null) {
			destinations = s.split(" ");
			for(String destination : destinations) {
				if(destination.equals(visit)) {
					count++;
	
					outputStream.println("***Reservation List***");
					outputStream.println("SSN\t" + "Firstname\t" + "Destination");
					outputStream.println(ssn + "\t" + fname + "\t" + destination);
					
					System.out.println("reservation was a success enjoy your flight");	
				}
			}
		}
		if(count ==0) {
			System.out.println("Sorry Sir/Mam that destination is not being traveled to by that Airline");
		}
		
		System.out.println("Add another Flight?");
		String a = input.next();
		String b = "yes";
		if(a == b) {
			purchase();
		}else {
			outputStream.flush();
			outputStream.close();
			input.close();			
		}

	}
	
	public void directp() throws IOException {
		System.out.println("hello sir/mam");
		System.out.println("Please choose your desired airline");
		String airline = input.next();
		
		String [] destinations = null;
		FileReader read = new FileReader("src\\"+airline+".txt");
		BufferedReader br = new BufferedReader(read);
		String s = null;
		
		System.out.println("Choose which location you will like to visit");
		
		String visit = input.next();
		System.out.println(visit);
		
		//cashcheck(destinations,br,visit,s);
		
		int count = 0;
		String filename = "reservations.txt";
		PrintWriter outputStream = new PrintWriter(filename);
		while((s=br.readLine()) !=null) {
			destinations = s.split(" ");
			for(String destination : destinations) {
				if(destination.equals(visit)) {
					count++;

					outputStream.println("***Reservation List***");
					outputStream.println("SSN\t" + "Firstname\t" + "Destination");
					outputStream.println(ssn + "\t" + fname + "\t" + visit);
					
					System.out.println("reservation was a success enjoy your flight");	
				}
			}

		}
		if(count ==0) {
			System.out.println("Sorry Sir/Mam that destination is not being traveled to by that Airline");
		}
	}
	
	/**public boolean cashcheck(String[] destinations, BufferedReader br, String visit, String s) throws IOException {
		System.out.println("Your Budget is " + budget);
		
		while((s=br.readLine()) !=null) {
			destinations = s.split("");
			
			for(String destination : destinations) {
					
			
				System.out.println(destination);
			}
			
		}
		return false;
	}**/
	
	
}
