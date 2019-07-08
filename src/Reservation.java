import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reservation {
	String airline;
	int size;
	Scanner flight2;
	public Reservation(String airline, int size, Scanner flight2) {
		this.airline = airline;
		this.size = size;
		this.flight2 = flight2;
	}
	
	//this method is importing the text file list and trying to copy everything into an array
	//did this for the simplicity, once it worked i was going to change it into a map 
	//I was also thinking of maybe having the purcahed flights be copied into another txt file
	public void purchase() throws FileNotFoundException {
		System.out.println(size);
		
		System.out.println("hello sir/mam");
		System.out.println("airline:" + airline);
		
		String [] destinations = new String[size];
		
		Scanner locations = new Scanner(new File("src\\"+airline+".txt"));
		for(int i = 0; i <size; i = i+	1) {
			destinations[i] = locations.nextLine();
			System.out.println(destinations[i]);//testing to see if everything is being copied to the array
		}
		locations.close();
		
	}
}
