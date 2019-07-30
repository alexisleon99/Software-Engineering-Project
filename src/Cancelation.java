import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
/**
 * This Class allows the cancellation or refund for a person/companions ticket/reservation.
 * 
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 */
public class Cancelation extends Login {
	static Scanner input = new Scanner(System.in);
	private String ssn;
	public Cancelation(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * In this specific method we find a reservation ticket and clear it out.
	 * <p>
	 * Once the the reservation ticket has been cleared, another method is called, the refund method.
	 * </p>
	 * @param ssn This is what helps find the users reservations.
	 * @return returns the file name in order to do some testing.
	 * @throws IOException an exception is thrown if there is a problem with the input.
	 */
	public static String cancel(String ssn) throws IOException {
		File f1 = new File("reservations" + ssn + ".txt");
		String filename = f1.toString();
		String[] words = null;
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String s;     
		String input = ssn;
		int count=0;
		while((s = br.readLine()) != null){
			words = s.split("\t"); 
		    for (String word : words) {
		    	if (word.equals(input)) {
		    		count++;
		        }
		    }
		}
		if(count!=0) {
			System.out.println("Ahh your SSN was found we will cancel per your request"); 
		    System.out.println("Refund will begin soon, than you for your service"); 
		}
		else{
			System.out.println("Sorry Sir/Mam you do not currently have a reservation with us");
		}
		br.close();
		return filename;
	}
	
	/**
	 * In this method we are able to change the users departure date.
	 * <p>
	 * Once the contents have been changed it regenerates the file with the new date.
	 * </p>
	 * @param ssn The ssn is what allows us to find the file and change its contents.
	 * @return returns the file name for testing purposes.
	 * @throws java.text.ParseException Throws an expception if there is a problem with the Date.
	 * @throws IOException an exception is thrown if there is a problem with the input.
	 */
	public static String reschedule(String ssn) throws java.text.ParseException, IOException {
		File fileToBeModified = new File("reservations" + ssn + ".txt");
		String filename = fileToBeModified.toString();
	    String oldContent = "";
	    BufferedReader reader = null;
	    FileWriter writer = null;
	    try{
	    	reader = new BufferedReader(new FileReader(fileToBeModified));
	        String line = reader.readLine();
	        while (line != null) {
	        	oldContent = oldContent + line + System.lineSeparator();
	            line = reader.readLine();
	        }
	        System.out.println("Enter in old departure in this format dd-M-yyyy hh:mm:ss");
	        String oldDeparture = input.nextLine();
	        System.out.println("Enter in new departure in this format dd-M-yyyy hh:mm:ss");
	        String newDeparture = input.nextLine();
	        String newContent = oldContent.replaceAll(oldDeparture, newDeparture);
	        writer = new FileWriter(fileToBeModified); 
	        writer.write(newContent);
	    }
	    catch (IOException e){
	    	e.printStackTrace();
	    }finally{
	    	try{
	    		reader.close();     
	            writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
		return filename;	
	}
	
	
	/**
	 * This method is called after the user has decided to cancel their reservation, not when they choose to reschedule.
	 * 
	 * <p>
	 * It finds the file that is going to be "Canceled" and finds the amount that the ticket cost and creates
	 * a new text file called Refund followed by the users ssn. This will notify the Refund was a success.
	 * </p>
	 * @param ssn We use this in order to find the text file, in order to find the amount that it had costed
	 * and use it to create a refund text file.
	 * @return Returns the new text file name in order to test. 
	 * @throws IOException IOException an exception is thrown if there is a problem with the input.
	 */
	public static String refund(String ssn) throws IOException {
		File f1 = new File("reservations" + ssn + ".txt");
		String[] words = null;
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String s;
		while((s = br.readLine()) != null){
			words=s.split(" ");
			for(int i = 0; i < words.length;i++) {
				if(words[i].equals("$")) {
					return startRefund(ssn, words, i);
				}
			}
		}
		
		br.close();
		return s;
	}

	private static String startRefund(String ssn, String[] words, int i) {
		String refund = words[ i + 1];
		System.out.println("We found your Reservation ticket we will now is your refund (check refund ticket with your ssn)");
		String filename = "Refund"+ssn+".txt";
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(filename);
			outputStream.println("**Refund***\n" + "Were sorry to see you go here is your refund of "+ refund);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String clear = "reservations"+ssn+".txt";
		PrintWriter outputStream2 = null;
		try {
			outputStream2 = new PrintWriter(clear);
			outputStream2.println();
			outputStream2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		return filename;
	}
}
