import java.io.*;
import java.util.*;

public class Reservation {
	String airline;
	int size;
	Scanner flight2;
	String fname;
	String ssn;
	public Reservation(String airline, int size, Scanner flight2,String fname, String ssn) {
		this.airline = airline;
		this.size = size;
		this.flight2 = flight2;
		this.fname = fname;
		this.ssn = ssn;
	}
	
	public void purchase() throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println(size);
		
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
		
		String [] destinations;
		FileReader read = new FileReader("src\\"+airline+".txt");
		BufferedReader br = new BufferedReader(read);
		String s;
		
		System.out.println("Choose which location you will like to visit");
		String visit = input.nextLine();
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
}
