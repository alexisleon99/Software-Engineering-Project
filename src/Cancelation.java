import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cancelation {
	static Scanner input = new Scanner(System.in);
	

	public static void cancel(String ssn) throws IOException {		
		      File f1=new File("reservations"+ssn+".txt"); //Creation of File Descriptor for input file
		      String[] words=null;  //Intialize the word Array
		      FileReader fr = new FileReader(f1);  //Creation of File Reader object
		      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
		      String s;     
		      String input=ssn;   // Input word to be searched
		      int count=0;   //Intialize the word to zero
		      while((s=br.readLine())!=null)   //Reading Content from the file
		      {
		         words=s.split(" ");  //Split the word using space
		          for (String word : words) 
		          {
		                 if (word.equals(input))   //Search for the given word
		                 {
		                   count++;    //If Present increase the count by one
		                 }
		          }
		      }
		      if(count!=0) {
		        System.out.println("Ahh your SSN was found we will cancel per your request"); 
		        System.out.println("Refund will begin soon, than you for your service"); 
		 		String filename = "reservations"+ssn+".txt";
		 		PrintWriter outputStream = null;
		 		outputStream = new PrintWriter(filename);
		        outputStream.println("");
			    outputStream.close();
		         
		      }
		      else
		      {
		         System.out.println("Sorry Sir/Mam you do not currently have a reservation with us");
		      }
	}
	public static void reschedule(String ssn) {
		System.out.println("Hello you will now reschedule flights, now choose which airline to start");
		String airline = input.next();
	}

}
