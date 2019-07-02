import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reservation {
	String airline;
	public Reservation(String airline) {
		this.airline = airline;
		
	}
	
	//this method is importing the text file list and trying to copy everything into an array
	//did this for the simplicity, once it worked i was going to change it into a map 
	//I was also thinking of maybe having the purcahed flights be copied into another txt file
	public void purchase() throws FileNotFoundException {
		int fsize = 0;
		File file = new File("src\\"+airline+".txt"); 
		Scanner flight = new Scanner(file); 
		  
		while (flight.hasNextLine()) {
			fsize = fsize++;
		}
		
		System.out.println(fsize);
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
		
		
		
		
		


		

		System.out.println(fsize);
		
		Scanner scan = new Scanner(new File("src\\"+airline+".txt"));
		
		

		
		String [] destinations = new String[fsize];
		
		Scanner locations = new Scanner(new File("src\\"+airline+".txt"));
		for(int i = 0; i <fsize; i = i+	1) {
			destinations[i] = locations.next();
			System.out.println(destinations[i]);
			
		}
		
		
		
		
	}

	

	
}
